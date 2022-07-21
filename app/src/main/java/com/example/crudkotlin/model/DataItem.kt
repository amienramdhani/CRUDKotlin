package com.example.crudkotlin.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
class DataItem :Serializable {
    @field:SerializedName("staff_name")
    val staffName : String? = null

    @field:SerializedName("staff_id")
    val staffId : String? = null

    @field:SerializedName("staff_hp")
    val staffHP : String? = null

    @field:SerializedName("staff_alamat")
    val staffAlamat : String? = null
}