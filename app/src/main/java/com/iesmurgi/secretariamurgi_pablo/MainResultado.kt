package com.iesmurgi.secretariamurgi_pablo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainResultado : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val closeButton = findViewById<Button>(R.id.button)
        closeButton.setOnClickListener {
            finishAffinity()
        }

        Toast.makeText(this,"Enhorabuena, has sido admitido en IES MURGI", Toast.LENGTH_LONG).show()
        val mibundle = intent.extras
        val nombre = mibundle?.getString("nombre")
        val curso = mibundle?.getString("curso")
        val optativas = mibundle?.getString("optativas")
        val familia = mibundle?.getString("familia")
        val ciclo = mibundle?.getString("ciclo")

        val tvnombre = findViewById<TextView>(R.id.tvNombre)
        val tvcurso = findViewById<TextView>(R.id.tvCurso)
        val tvoptativas = findViewById<TextView>(R.id.tvOptativas)
        val tvfamilia = findViewById<TextView>(R.id.tvFamilia)
        val tvciclo = findViewById<TextView>(R.id.tvCiclo)
        tvnombre.text = nombre.toString()
        tvcurso.text = curso.toString()
        if (optativas == null){

        }else{
            tvoptativas.text = optativas.toString()
        }
        tvfamilia.text = familia.toString()
        tvciclo.text = ciclo.toString()


    }

}