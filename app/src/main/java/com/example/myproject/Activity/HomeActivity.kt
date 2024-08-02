package com.example.myproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.Adapter.CategoryAdapter
import com.example.myproject.Adapter.JobAdapter
import com.example.myproject.Model.JobModel
import com.example.myproject.R
import com.example.myproject.ViewModel.MainViewModel
import com.example.myproject.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initLocation()
        initRecyclerViewCat()
        initRecyclerViewSuggest()
        initRecyclerViewRecent("0")

    }

    private fun initRecyclerViewRecent(cat:String) {
        val data: List<JobModel>
        if(cat=="0"){
            data=mainViewModel.loadData().sortedBy { it.category}
        }else {
            data=mainViewModel.loadData().filter { it.category==cat}
        }

        binding.viewRecent.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.viewRecent.adapter = JobAdapter(data)
    }


    private fun initRecyclerViewSuggest() {
        binding.progressBarSuggested.visibility=View.VISIBLE
        binding.viewSuggested.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.viewSuggested.adapter=JobAdapter(mainViewModel.loadData())
        binding.progressBarSuggested.visibility=View.GONE
    }

    private fun initLocation() {
        val adapter= ArrayAdapter(this,R.layout.spinner_item, mainViewModel.loadLocation())

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.locationSpin.adapter = adapter

    }

    private fun initRecyclerViewCat(){
        binding.progressBarCategory.visibility= View.VISIBLE
        binding.viewCategory.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.viewCategory.adapter=
            CategoryAdapter(mainViewModel.loadCategory(), object : CategoryAdapter.ClickListener{
                override fun onClick(category: String) {
                    initRecyclerViewRecent(category)
                }

            })
        binding.progressBarCategory.visibility=View.GONE
    }

}