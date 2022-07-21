package com.example.crudkotlin.presenter

import com.example.crudkotlin.model.DataItem

interface CrudView {
    //untuk Get data
    fun onSuccessGet(data: List<DataItem>?)
    fun onFailedGet(msg : String)

    //untuk delete
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)

    //untuk Add
    fun successAdd(msg: String)
    fun errorAdd(msg: String)

    //untuk Update
    fun onSuccessUpdate(msg: String)
    fun onErrorUpdate(msg: String)
}