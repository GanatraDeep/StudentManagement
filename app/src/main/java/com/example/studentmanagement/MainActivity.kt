package com.example.studentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        Textboxes
        val edittextRno : EditText = findViewById(R.id.edittextRno)
        val edittextName : EditText = findViewById(R.id.edittextName)
        val edittextM1 : EditText = findViewById(R.id.edittextM1)
        val edittextM2 : EditText = findViewById(R.id.edittextM2)
        val edittextM3 : EditText = findViewById(R.id.edittextM3)

//        Buttons
        val btnAdd : Button = findViewById(R.id.btnAdd)

//        RecyclerView
        val rcview : RecyclerView = findViewById(R.id.rcview)

//        Data Class List
        val students = ArrayList<Student>();

//        Custom Adapter for Student
        val studentAdapter = StudentMainActivityAdapter(students)

//        Setting the custom adapter and layout manager
        rcview.adapter = studentAdapter
        rcview.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener(View.OnClickListener {
            val rno = Integer.parseInt(edittextRno.text.toString())
            val name = edittextName.text.toString()
            val m1 = Integer.parseInt(edittextM1.text.toString())
            val m2 = Integer.parseInt(edittextM2.text.toString())
            val m3 = Integer.parseInt(edittextM3.text.toString())

            val student = Student(rno, name, m1, m2, m3)
            students.add(student)

            studentAdapter.notifyDataSetChanged()
        })
    }
}