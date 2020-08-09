package com.example.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_to_do.*

class CompleteToDoActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_complete_to_do)

		val todo= intent.extras!!.getString("todoTitle")

		todoTextView.text=todo

		completeBtn.setOnClickListener {
			var prefs=getSharedPreferences("com.example.todolist.sharedPrefs",
				Context.MODE_PRIVATE)
			var todos= prefs.getStringSet("todoString",setOf())!!.toMutableSet()
			todos.remove(todo)

			prefs.edit().putStringSet(getString(R.string.ToDo_String),todos).apply()

			finish()

		}

		editBtn.setOnClickListener {
		}
	}
}
