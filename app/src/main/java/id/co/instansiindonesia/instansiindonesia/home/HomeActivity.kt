package id.co.instansiindonesia.instansiindonesia.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import id.co.instansiindonesia.instansiindonesia.R
import id.co.instansiindonesia.instansiindonesia.api.APIService
import id.co.instansiindonesia.instansiindonesia.api.ResponeInstansi
import id.co.instansiindonesia.instansiindonesia.model.Instansi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var adapterHome: AdapterHome
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private var instansi = ArrayList<Instansi>()
    private lateinit var namaKabupten: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        spinner = findViewById(R.id.spinner)
        recyclerView = findViewById(R.id.recyclerView)
        swipeRefreshLayout = findViewById(R.id.swipe)

        val spinnerKabupaten = resources.getStringArray(R.array.kabupaten)
        val spinnerAdapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, spinnerKabupaten)
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                namaKabupten = spinner.selectedItem.toString()

                loadInstitusi(namaKabupten)
            }

        }

        swipeRefreshLayout.setOnRefreshListener {
            loadInstitusi(namaKabupten)
        }
    }

    private fun loadInstitusi(nama_kabupaten: String) {
        swipeRefreshLayout.isRefreshing = true

        val service = APIService.create()
        val call = service.view("api/instansi/daftar_instansi/$nama_kabupaten")
        call.enqueue(object : Callback<ResponeInstansi> {
            override fun onFailure(call: Call<ResponeInstansi>?, t: Throwable?) {
                swipeRefreshLayout.isRefreshing = false
                Log.d("Log : ", t?.localizedMessage)
                Toast.makeText(baseContext, "Ops, Terjadi Kesalahan", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponeInstansi>?, response: Response<ResponeInstansi>) {
                if (response.isSuccessful) {
                    instansi = response.body()?.instansi as ArrayList<Instansi>

                    adapterHome = AdapterHome(baseContext, instansi) {
                        //OnClick
                    }
                    recyclerView.layoutManager = LinearLayoutManager(baseContext)
                    recyclerView.adapter = adapterHome
                } else {

                    Toast.makeText(baseContext, response.message(), Toast.LENGTH_LONG).show()
                }
                swipeRefreshLayout.isRefreshing = false
            }

        })
    }
}
