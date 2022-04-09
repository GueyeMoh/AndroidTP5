package com.example.tp5

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.lang.System.load

class MonAdapter(val context: MainActivity,
                 private val element: List<Characters>,
                 private val listener: AdapterListener
):RecyclerView.Adapter<MonAdapter.ViewHolder>() {
    interface AdapterListener{fun onItemClicked(clickedView: View)}


    class ViewHolder(val element: View):RecyclerView.ViewHolder(element) {
        val name = element.findViewById<TextView>(R.id.nom)
        val birthday = element.findViewById<TextView>(R.id.date_de_nais)
        val image = element.findViewById<ImageView>(R.id.mon_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        view.setOnClickListener{
            listener.onItemClicked(view)
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentElement = element[position]
        holder.name?.text = currentElement.name
        holder.birthday?.text = currentElement.birthday
        //holder.image?.setImageResource(image.load(currentElement.img))
        Glide.with(context).load(Uri.parse(currentElement.img)).into(holder.image) //loading image with glide



    }

    override fun getItemCount(): Int = element.size
}