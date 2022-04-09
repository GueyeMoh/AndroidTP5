package com.example.tp5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment(private val context: MainActivity): Fragment(), MonAdapter.AdapterListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repo = Repository()
        val view = inflater.inflate(R.layout.main_fragment_layout, container, false)
        val mon_recycler = view.findViewById<RecyclerView>(R.id.mon_recycler)
        mon_recycler.layoutManager = LinearLayoutManager(context)
        mon_recycler.adapter = MonAdapter(context, repo.breaking, this )
        return view
    }

    override fun onItemClicked(clickedView: View) {
        val repo = Repository()
        FragmentDetail(adapter = MonAdapter(context, repo.breaking,this)).show()
    }
}