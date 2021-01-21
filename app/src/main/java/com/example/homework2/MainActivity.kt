package com.example.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var add_btn: Button
    private lateinit var page2_btn: Button
    private lateinit var surname_edit_text : EditText
    private lateinit var name_edit_text: EditText
    private lateinit var num_of_students: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_btn = findViewById(R.id.add_student_btn)
        page2_btn = findViewById(R.id.second_page_btn)
        surname_edit_text = findViewById(R.id.surname_of_student)
        name_edit_text = findViewById(R.id.name_of_student)
        num_of_students = findViewById(R.id.number_of_student)

        val list = ArrayList<Student>()
        var size = 10
        num_of_students.text = size.toString() + " Students"

        for(i in 0 until size){
            list.add(Student("Student$i"))
        }
        Log.d("listOf" , list.toString())

        add_btn.setOnClickListener {
            if(surname_edit_text.text.isEmpty() || name_edit_text.text.isEmpty()){
                Toast.makeText(baseContext, "Please Fill Your Name And Surname", Toast.LENGTH_SHORT).show()
            }
            else{
                var fullName = surname_edit_text.text.toString().trim() +" "+ name_edit_text.text.toString().trim()
                val newStudent = Student(fullName)
                Log.d("full name" , fullName )
                if(list.contains(newStudent)){
                    Toast.makeText(baseContext, "${newStudent.fullName} is already in list", Toast.LENGTH_SHORT).show()
                }
                else{
                    list.add(newStudent)
                    size++
                    num_of_students.setText("$size Students")
                    surname_edit_text.text.clear()
                    name_edit_text.text.clear()
                }
            }
        }
        page2_btn.setOnClickListener {
            val intent = Intent(this@MainActivity , Page2::class.java)
            intent.putExtra("list" , list)
            startActivity(intent)
        }


    }


}