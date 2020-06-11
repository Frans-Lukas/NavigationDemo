package com.example.bottomnavigationactivity.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigationactivity.MainActivity
import com.example.bottomnavigationactivity.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val num = 100
        val strings = arrayOfNulls<String>(num)
        for (i in 0 until num) {
            strings[i] = "test$i"
        }

        val adapter =
            ArrayAdapter(
                activity!!.applicationContext,
                android.R.layout.simple_list_item_1,
                strings
            )
        root.list_view.adapter = adapter
        val activity = activity
        root.doubly_nav_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    (activity as MainActivity).navigateToDepthOne()
                    true
                }
                R.id.navigation_dashboard -> {
                    true
                }
                R.id.navigation_notifications -> {
                    true
                }
                else -> false
            }
        }

        return root
    }
}