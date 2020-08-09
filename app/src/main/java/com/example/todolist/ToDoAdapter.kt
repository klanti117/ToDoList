package com.example.todolist

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class ToDoAdapter(val todosArr:List<String>) : RecyclerView.Adapter<ToDoAdapter.TodoHolder>() {

	class TodoHolder(v: View):RecyclerView.ViewHolder(v),View.OnClickListener{
		var todoTitle:String=""
		var view:View=v

		init {
			v.setOnClickListener(this)
		}

		fun bindData(todoTitle:String){
			this.todoTitle=todoTitle
			view.textView.text=todoTitle
		}
		override fun onClick(v: View?) {
			Log.d("++++","text clicked")
			val intent= Intent(view.context,CompleteToDoActivity::class.java)
			intent.putExtra("todoTitle",todoTitle)
			startActivity(view.context,intent,null)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
		return TodoHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,
			false))
	}

	override fun getItemCount(): Int {
		return todosArr.count()
	}

	override fun onBindViewHolder(holder: TodoHolder, position: Int) {
		holder.bindData(todosArr[position])
	}
}
