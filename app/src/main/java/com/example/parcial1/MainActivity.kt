package com.example.parcial1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var nuevoNombre: EditText
    private lateinit var buttonNuevoAlumno: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nuevoNombre = findViewById(R.id.inputNombre)
        buttonNuevoAlumno = findViewById(R.id.buttonListado)

        buttonNuevoAlumno.setOnClickListener {
            val nameEntered = nuevoNombre.text.toString().trim()
            if (nameEntered.isNotEmpty())
                confirmarNuevo(nameEntered)
            else
                Toast.makeText(this, "Debes ingresar un nombre :)", Toast.LENGTH_SHORT).show()
        }
    }
    private fun confirmarNuevo(studentName: String) {
        val sharedPreference = getSharedPreferences("studentName_Preference", Activity.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("studentName", studentName)
        editor.apply()
        Toast.makeText(this, "Perfecto!", Toast.LENGTH_SHORT).show()
        val intentToList = Intent(this, ListadoAlumnos::class.java)
        startActivity(intentToList)
    }
}