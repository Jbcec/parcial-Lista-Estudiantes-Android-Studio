package com.example.parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetalleAlumno : AppCompatActivity() {
    private lateinit var nombreAlumno: TextView
    private lateinit var edadAlumno: TextView
    private lateinit var fotoAlumno: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_alumno)
        nombreAlumno = findViewById(R.id.nombreDetalleAlumno)
        edadAlumno = findViewById(R.id.edadAlumnoDetalle)
        fotoAlumno = findViewById(R.id.fotoAlumnoDetalle)

        val bundle = intent.extras
        val getName = bundle?.getString("name", "")
        val getAge = bundle?.getString("age", "")
        val getUrl = bundle?.getString("url") ?: ""

        nombreAlumno.text = "Nombre: $getName"
        edadAlumno.text = "Edad: $getAge"

        Glide.with(applicationContext)
            .load(getUrl)
            .into(fotoAlumno)
    }
}