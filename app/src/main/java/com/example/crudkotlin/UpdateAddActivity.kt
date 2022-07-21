package com.example.crudkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crudkotlin.model.DataItem
import com.example.crudkotlin.presenter.CrudView
import com.example.crudkotlin.presenter.Presenter
import kotlinx.android.synthetic.main.activity_update_add.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

@Suppress("SENSELESS_COMPARISON")
class UpdateAddActivity : AppCompatActivity(), CrudView {

    private lateinit var presenter: Presenter
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)

        presenter = Presenter(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null){
            btnAction.text = "Tambah"
            btnAction.onClick {
                presenter.addData(
                    etName.text.toString(),
                    etPhone.text.toString(),
                    etAlamat.text.toString()
                )
            }
        }else if (itemDataItem != null){
            btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            etName.setText(item?.staffName.toString())
            etPhone.setText(item?.staffHP.toString())
            etAlamat.setText(item?.staffAlamat.toString())
            btnAction.onClick {
                presenter.updateData(
                    item?.staffId?: "",
                    etName.text.toString(),
                    etPhone.text.toString(),
                    etAlamat.text.toString()
                )
                finish()
            }
        }
    }

    override fun successAdd(msg: String) {
        startActivity<MainActivity>()
        finish()
    }

    override fun errorAdd(msg: String) {

    }

    override fun onSuccessUpdate(msg: String) {
        startActivity<MainActivity>()
        finish()
    }

    override fun onErrorUpdate(msg: String) {

    }

    override fun onSuccessGet(data: List<DataItem>?) {

    }

    override fun onFailedGet(msg: String) {

    }

    override fun onSuccessDelete(msg: String) {

    }

    override fun onErrorDelete(msg: String) {

    }
}