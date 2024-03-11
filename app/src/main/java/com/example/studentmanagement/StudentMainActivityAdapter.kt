package com.example.studentmanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentMainActivityAdapter(val students : ArrayList<Student>):RecyclerView.Adapter<StudentMainActivityAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val txtRollno : TextView = itemView.findViewById(R.id.txtRollno)
        val txtName : TextView = itemView.findViewById(R.id.txtName)
        val txtM1 : TextView = itemView.findViewById(R.id.txtM1)
        val txtM2 : TextView = itemView.findViewById(R.id.txtM2)
        val txtM3 : TextView = itemView.findViewById(R.id.txtM3)
        val txtTotal : TextView = itemView.findViewById(R.id.txtTotal)
        val txtPercent : TextView = itemView.findViewById(R.id.txtPercent)
        val txtGrade : TextView = itemView.findViewById(R.id.txtGrade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return students.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students.get(position)

        holder.txtRollno.text = student.rno.toString()
        holder.txtName.text = student.name.toString()
        holder.txtM1.text = "Maths : " + student.m1.toString()
        holder.txtM2.text = "Science : " + student.m2.toString()
        holder.txtM3.text = "English : " + student.m3.toString()
        holder.txtTotal.text = "Total : " + (student.m1 + student.m2 + student.m3).toString()
        holder.txtPercent.text = "Percent : " + ((student.m1 + student.m2 + student.m3) / 3).toString()
        holder.txtGrade.text = getGrade(student.m1, student.m2, student.m3)
    }

    fun getGrade(m1 : Int, m2 : Int, m3 : Int) : String
    {
        return when((m1 + m2 + m3) / 3)
        {
            in 90..100 -> "A"
            in 75 until 90 -> "B"
            in 50 until 75 -> "C"
            else -> "F"
        }
    }

}