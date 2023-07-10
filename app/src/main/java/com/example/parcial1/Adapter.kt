package com.example.parcial1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) :
    ListAdapter<Alumno, Adapter.ViewHolder>(DiffCallBack){
    lateinit var onItemClickListener: (Alumno) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombreAlumno: TextView = view.findViewById(R.id.nomberAlumno)
        private val fotoAlumno: ImageView = view.findViewById(R.id.fotoAlumno)

        fun bind(student: Alumno) {
            nombreAlumno.text = "Alumno: ${student.name}"
            Glide.with(context)
                .load(student.urlFoto)
                .into(fotoAlumno)
            view.setOnClickListener {
                onItemClickListener(student)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.listado_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = getItem(position)
        holder.bind(student)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Alumno>() {
        override fun areItemsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return oldItem == newItem
        }
    }
}