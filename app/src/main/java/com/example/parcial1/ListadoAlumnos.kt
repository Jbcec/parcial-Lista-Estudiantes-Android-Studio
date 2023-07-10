package com.example.parcial1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListadoAlumnos : AppCompatActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var nombreNuevo: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_alumnos)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = Adapter(applicationContext)
        recyclerView.adapter = adapter

        val sharedPreferences = getSharedPreferences("studentName_Preference", Activity.MODE_PRIVATE)
        nombreNuevo = sharedPreferences.getString("studentName", "") ?: ""

        adapter.submitList(crearListado(nombreNuevo))
        adapter.onItemClickListener = { student ->
            val intent = Intent(this, DetalleAlumno::class.java)
            intent.putExtra("name", student.name)
            intent.putExtra("age", student.age.toString())
            intent.putExtra("url", student.urlFoto)
            startActivity(intent)
        }
    }
    private fun crearListado(name: String): MutableList<Alumno>? {
        return mutableListOf(
            Alumno(1, name, 22, "https://www.dictionary.com/e/wp-content/uploads/2018/03/This-is-Fine-300x300.jpg"),
            Alumno(2, "Laura", 21, "https://media.istockphoto.com/id/1190367451/es/foto/estudiante-de-derecho-de-pie-en-la-entrada-al-edificio-de-la-universidad.jpg?s=612x612&w=0&k=20&c=4zUSZMQ67bSv_Z7dFL5bNK3EbTyFbljltLHVlh0qEyY="),
            Alumno(3, "Pedro", 18, "https://media.istockphoto.com/id/1137020060/es/foto/estudiante-universitario-en-ropa-casual.jpg?s=612x612&w=0&k=20&c=HXzpIPaQZQ_NTnwbenEdEyV9pi8EhZXlMsI9RApg8w0="),
            Alumno(4, "Gunther", 17, "https://media.istockphoto.com/id/1366725032/es/foto/adolescente-sonriente-tomando-notas-mientras-usa-una-computadora-port%C3%A1til-durante-una-clase-en.jpg?s=612x612&w=0&k=20&c=d8Wzna4jiiuHmuLfEfUGDeRWCv_CK_2Bx9m6U5vHfPg="),
            Alumno(5, "Franco", 29, "https://media.istockphoto.com/id/1301038922/es/foto/inteligente-joven-estudiante-de-raza-mixta-usando-port%C3%A1til-aislado-sobre-fondo-blanco.jpg?s=612x612&w=0&k=20&c=r7_AFRr6WR3txreH0rimRXBnw7zxw4Is-rAz6EZLSkk="),
            Alumno(6, "Julieta", 19, "https://media.istockphoto.com/id/1396453889/es/foto/hermosa-mujer-con-anteojos-sosteniendo-libros.jpg?s=612x612&w=0&k=20&c=y0u_qbiA0q2o8cZ7r59pYhSDRQqAQrgP_MwL1YRAnLo="),
            Alumno(7, "Florencia", 13, "https://media.istockphoto.com/id/1249078123/es/foto/retrato-de-estudiante-universitario-en-el-campus.jpg?s=612x612&w=0&k=20&c=-NVc2WVL-mmooegC8edWS8CATUdfS4HInvTuKqpEWLM="),
            Alumno(8, "Marcos", 23, "https://media.istockphoto.com/id/1339432131/es/foto/estudiante-adolescente-afroamericano-positivo-con-mochila-tablet-pc-y-auriculares-estudiando.jpg?s=612x612&w=0&k=20&c=IIiQuvbgjCKsA5BWmlpNvl2ciu7Vy606GSt_3_xB-PY="),
            Alumno(9, "Juan Pablo", 20, "https://media.istockphoto.com/id/1342062117/es/foto/estudiante-%C3%A1rabe-inteligente-con-mochila-y-libros.jpg?s=612x612&w=0&k=20&c=5UWNFZ_2al_MWBcjEP9wU6P_i9AyYcXBCT8iKxRbZKw="),
            Alumno(10, "María", 18, "https://media.istockphoto.com/id/1368068269/es/foto/hermosa-mujer-que-regresa-a-la-escuela.jpg?s=612x612&w=0&k=20&c=g58bWJVeEgcT-6OMJQHnVlDyzRUkFCo19wjYA4YxPYo=")
        )
    }
}