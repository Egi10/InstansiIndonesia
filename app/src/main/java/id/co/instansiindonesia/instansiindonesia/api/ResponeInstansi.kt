package id.co.instansiindonesia.instansiindonesia.api

import com.google.gson.annotations.SerializedName
import id.co.instansiindonesia.instansiindonesia.model.Instansi

class ResponeInstansi(
        @SerializedName("daftar_instansi")
        val instansi: List<Instansi>?,

        @SerializedName("message")
        val message: String?)