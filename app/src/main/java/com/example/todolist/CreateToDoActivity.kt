package com.example.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_to_do.*

class CreateToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

		saveButton.setOnClickListener {
			var todoTitle=""
			if(impCheckBox.isChecked){
				todoTitle="‼️ "+addToDoEditText.text.toString()
			}else{
				todoTitle=addToDoEditText.text.toString()
			}

			var prefs=getSharedPreferences(getString(R.string.SHARED_PREF_NAME),
				Context.MODE_PRIVATE)
			//to add
			var todos= prefs.getStringSet(getString(R.string.ToDo_String),setOf())!!.toMutableSet()
			todos.add(todoTitle)
			prefs.edit().putStringSet("todoString",todos).apply()

			finish()//to move back to previous activity
		}



	}
}
