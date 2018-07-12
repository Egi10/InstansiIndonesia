package id.co.instansiindonesia.instansiindonesia.model

import com.google.gson.annotations.SerializedName

data class Instansi(
        @SerializedName("id")
        val Id: String? = null,

        @SerializedName("id_kabupaten")
        val IdKabupaten: String? = null,

        @SerializedName("nama_kabupaten")
        val NamaKabupaten: String? = null,

        @SerializedName("jenis_instansi")
        val JenisInstansi: String? = null,

        @SerializedName("nama_instansi")
        val NamaInstansi: String? = null,

        @SerializedName("nomor_instansi")
        val NomorInstansi: String? = null,

        @SerializedName("alamat_instansi")
        val AlamatInstansi: String? = null,

        @SerializedName("lat_")
        val Lat: String? = null,

        @SerializedName("long_")
        val Long: String? = null)