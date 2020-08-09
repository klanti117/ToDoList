package com.example.todolist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	lateinit var layoutManager:LinearLayoutManager
	lateinit var adapter:ToDoAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)


		fabBtn.setOnClickListener {
			val intent= Intent(this, CreateToDoActivity::class.java)
			startActivity(intent)
		}
	}

	override fun onResume() {
		super.onResume()
		var prefs=getSharedPreferences("com.example.todolist.sharedPrefs",
			Context.MODE_PRIVATE)
		//to add
		var todos= prefs.getStringSet("todoString",setOf())!!.toMutableSet()

//		LAYOUT
		layoutManager= LinearLayoutManager(this)
		recyclerViewID.layoutManager=layoutManager

//		ADAPTER
		adapter=ToDoAdapter(todos.toList())
		recyclerViewID.adapter=adapter
		println(todos)
	}
}
