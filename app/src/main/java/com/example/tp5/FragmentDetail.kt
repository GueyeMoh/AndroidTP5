package com.example.tp5

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class FragmentDetail(private val adapter:MonAdapter,
                     private val currentActor: Characters): Dialog(adapter.context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) //pas de titre pour le layout
        setContentView(R.layout.fragment_details_layout)
        showDialog()
        closeButton()
    }

    private fun closeButton() {
        findViewById<ImageView>(R.id.close).setOnClickListener{dismiss()}
    }

    private fun showDialog() {
        val imageDetail = findViewById<ImageView>(R.id.image_detail)
        Glide.with(adapter.context).load(Uri.parse(currentActor.img)).into(imageDetail)
        findViewById<TextView>(R.id.name_detail).text = currentActor.name
        findViewById<TextView>(R.id.birthday_datail).text = currentActor.birthday
        findViewById<TextView>(R.id.status_detail).text = currentActor.status
        findViewById<TextView>(R.id.nickname_detail).text = currentActor.nickname
    }

}