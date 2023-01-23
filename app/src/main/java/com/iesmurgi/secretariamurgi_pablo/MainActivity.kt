package com.iesmurgi.secretariamurgi_pablo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import com.iesmurgi.secretariamurgi_pablo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        Toast.makeText(this,"Para enviar tu solicitud pulsa en el LOGO", Toast.LENGTH_LONG).show()

        val spinnerPadre = bind.spinnerPadre
        val spinnerHijo = bind.spinnerHijo
        val listaCiclos = Ciclos.androidSource
        var familia : String = ""
        var ciclo : String = ""



        var adaptadorPadre: ArrayAdapter<Ciclos> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCiclos)
        spinnerPadre?.adapter = adaptadorPadre

        spinnerPadre?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {

                    }
                    1 -> {
                        familia = "Informática y comunicaciones"
                        val adaptadorHijo = ArrayAdapter.createFromResource(
                            this@MainActivity,
                            R.array.ciclos_Informatica,
                            android.R.layout.simple_spinner_item
                        )

                        adaptadorHijo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerHijo.adapter = adaptadorHijo

                        spinnerHijo?.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    when (position) {
                                        0 -> {
                                            ciclo = "Desarrollo de Aplicaciones Multiplataforma (DAM)"
                                        }
                                        1 -> {
                                            ciclo = "Desarrollo de Aplicaciones Web (DAW)"
                                        }
                                        2 -> {
                                            ciclo = "Sistemas Microinformáticos y Redes (SMR)"
                                        }
                                    }
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }
                            }
                    }
                    2 -> {
                        familia = "Transporte y mantenimiento de vehiculos"
                        val innerAdapter = ArrayAdapter.createFromResource(this@MainActivity, R.array.ciclos_Automocion, android.R.layout.simple_spinner_item)
                        innerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerHijo.adapter = innerAdapter

                        spinnerHijo?.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    when (position) {
                                        0 -> {
                                            ciclo = "Técnico Superior en Automoción"
                                        }
                                        1 -> {
                                            ciclo = "Técnico Superior en Mantenimiento Aeromecánico de Helicópteros con Motor de Pistón"
                                        }
                                        2 -> {
                                            ciclo = "Técnico Superior en Mantenimiento Aeromecánico de Aviones con Motor de Turbina"
                                        }
                                    }
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }
                            }
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val rgCurso : RadioGroup = bind.rbCurso
        val religionRadioGroup = bind.rg1
        val matematicasRadioGroup = bind.rg2
        val inglesRadioGroup = bind.rg3
        val fisicaRadioGroup = bind.rg4



        rgCurso.setOnCheckedChangeListener { _, checkedId ->



        }

        val nombrePersona : EditText = bind.etNombre
        var nombrePersonaText : String = nombrePersona.text.toString()
        nombrePersona.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                nombrePersonaText = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        var curso:String = ""
        var Optativas:String = ""
        var rbReligion : RadioButton = bind.rbReligion
        var rbMates : RadioButton = bind.rbAcademica
        var rbIngles : RadioButton = bind.rbIngles
        var rbFisica : RadioButton = bind.rbFisica
        var LinearLayout : LinearLayout = bind.LinealLayout
        rgCurso.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rbEso) {
                curso = "ESO"
                religionRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (rbReligion.isChecked){
                        Optativas += "Religion "
                    }else{
                        Optativas += "Valores "
                    }
                    println("**************************"+Optativas)
                }
                matematicasRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (rbMates.isChecked){
                        Optativas += "Mates academicas "
                    }else{
                        Optativas += "Mates aplicadas "
                    }
                }

                inglesRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (rbIngles.isChecked){
                        Optativas += "Ingles  "
                    }else{
                        Optativas += "Francés  "
                    }
                }

                fisicaRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (rbFisica.isChecked){
                        Optativas += "Física "
                    }else{
                        Optativas += "Griego  "
                    }
                }
            }
            if (checkedId == R.id.rbBach) {
                curso = "Bachillerato"

                religionRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (rbReligion.isChecked){
                        Optativas += "Religion "
                    }else{
                        Optativas += "Valores "
                    }

                }
                matematicasRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (rbMates.isChecked){
                        Optativas += "Mates academicas "
                    }else{
                        Optativas += "Mates aplicadas "
                    }
                }

                inglesRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (rbIngles.isChecked){
                        Optativas += "Ingles  "
                    }else{
                        Optativas += "Francés  "
                    }
                }

                fisicaRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (rbFisica.isChecked){
                        Optativas += "Física "
                    }else{
                        Optativas += "Griego  "
                    }
                }
            }
            if (checkedId == R.id.rbFP) {
                curso = "Ciclo Formativo"
                religionRadioGroup.isVisible = false
                matematicasRadioGroup.isVisible = false
                inglesRadioGroup.isVisible = false
                fisicaRadioGroup.isVisible = false
                LinearLayout.isVisible = true

                religionRadioGroup.clearCheck()
                matematicasRadioGroup.clearCheck()
                inglesRadioGroup.clearCheck()
                fisicaRadioGroup.clearCheck()

            } else {
                religionRadioGroup.isVisible = true
                matematicasRadioGroup.isVisible = true
                inglesRadioGroup.isVisible = true
                fisicaRadioGroup.isVisible = true
                LinearLayout.isVisible = false
            }
        }


        val ivLogo = bind.ivLogo
        ivLogo.setOnClickListener(){
            if (bind.rbBach.isChecked|| bind.rbEso.isChecked){
                val enviar1 = Intent(this,MainResultado::class.java)
                enviar1.putExtra("nombre",nombrePersonaText)
                enviar1.putExtra("curso", curso)
                enviar1.putExtra("optativas", Optativas)
                startActivity(enviar1)
            }else{
                val enviar2 = Intent(this,MainResultado::class.java)
                enviar2.putExtra("nombre",nombrePersonaText)
                enviar2.putExtra("curso", curso)
                enviar2.putExtra("familia", familia)
                enviar2.putExtra("ciclo", ciclo)
                startActivity(enviar2)
            }
        }
    }
}