package com.filipkowicz.examples.ui.main

import HeaderItemDecoration
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.filipkowicz.examples.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private val adapter = Adapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false).also {
            it.findViewById<RecyclerView>(R.id.recycler).apply {
                adapter = this@MainFragment.adapter
                addItemDecoration(HeaderItemDecoration(this) {
                    this@MainFragment.adapter.getItemViewType(it) == R.layout.header_layout
                })
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        viewModel.items.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

    }

}
