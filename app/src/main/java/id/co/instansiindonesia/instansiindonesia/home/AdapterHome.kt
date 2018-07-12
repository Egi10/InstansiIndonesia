package id.co.instansiindonesia.instansiindonesia.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.instansiindonesia.instansiindonesia.R
import id.co.instansiindonesia.instansiindonesia.model.Instansi
import kotlinx.android.synthetic.main.layout_list_home.view.*

class AdapterHome(private val context: Context, private val instansi: List<Instansi>, private val listener: (Instansi) -> Unit)
    : RecyclerView.Adapter<AdapterHome.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AdapterHome.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_list_home, parent, false))

    override fun getItemCount(): Int = instansi.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(instansi[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(instansi: Instansi, listener: (Instansi) -> Unit) {
            itemView.namaInstansi.text = instansi.NamaInstansi
            itemView.nomorInstansi.text = instansi.NomorInstansi
            itemView.alamatInstansi.text = instansi.AlamatInstansi
            val cekImage = instansi.JenisInstansi
            if (cekImage.equals("Pemadam")) {
                itemView.image.setImageResource(R.drawable.ic_fire_station)
            } else if (cekImage.equals("Rumkit")) {
                itemView.image.setImageResource(R.drawable.ic_hospital)
            } else if (cekImage.equals("Polisi")) {
                itemView.image.setImageResource(R.drawable.ic_police_station)
            }

            itemView.setOnClickListener {
                listener(instansi)
            }
        }
    }
}