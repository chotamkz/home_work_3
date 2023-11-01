package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var carList: ArrayList<Car>
    private lateinit var carAdapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        carList = ArrayList()

        carList.add(Car(R.drawable.mustang , name = "Mustang"))
        carList.add(Car(R.drawable._11 , name = "Porsche 911"))
        carList.add(Car(R.drawable.audi , name = "Audi"))
        carList.add(Car(R.drawable.gelik , name = "Gelik"))
        carList.add(Car(R.drawable.landrover , name = "Land Rover"))
        carList.add(Car(R.drawable.mercedec , name = "Mercedes"))



        carAdapter = CarAdapter(carList)
        recyclerView.adapter = carAdapter

        carAdapter.onItemClick = {
            val intent = Intent(this ,DetailedActivity::class.java)
            intent.putExtra("car", it)
            startActivity(intent)
        }
    }
}