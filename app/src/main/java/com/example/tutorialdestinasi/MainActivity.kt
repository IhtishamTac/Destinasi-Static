package com.example.tutorialdestinasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.tutorialdestinasi.Adapters.ListDestinationAdapter
import com.example.tutorialdestinasi.Models.Destinations
import com.example.tutorialdestinasi.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ListDestinationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ListDestinationAdapter(this, listOf())
        binding.desRecycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        getDestination()
    }

    private fun getDestination(){
        lifecycleScope.launch(Dispatchers.IO){
            val data = destinations()
            Log.d("Destinasi", data.toString())
            launch(Dispatchers.Main) {
                adapter.datas = data
                adapter.notifyDataSetChanged()
            }
        }
    }

    private suspend fun destinations() : List<Destinations> {
        kotlinx.coroutines.delay(2000)
        return listOf(
            Destinations(1, "Gunung Bromo", "gunungbromo"),
            Destinations(2, "Raja Ampat", "raja_ampat_thumbnail")
        )
    }
}