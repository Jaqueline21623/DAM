package pe.edu.upeu.calxml

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtresultado:EditText
    private var valAnt=0.0
    private var valAct=0.0
    private var operador=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtresultado=findViewById(R.id.txtresult)

    }

    fun botones (){
        var button= arrayOf(R.id.btn4,R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnx, R.id.btnm, R.id.btni)
        for (button in buttons){
            var bin=findViewById<Button>(button)
            binset        }
    }

    fun onclick (view:View){
        when(view.id){
            R.id.btn4,R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9->{
                var botonX=findViewById<Button>(view.id)
                appencontent(botonX.text.toString())
            }
        }
    }

    fun appencontent(valor: String){
        txtresultado.append(valor)
    }
    fun operador(oper:String){
        operador=oper
        valAnt=txtresultado.text.toString().toDouble()
        txtresultado.text.clear()
    }

    fun operacion(){
        valAct=txtresultado.text.toString().toDouble()
        var resulx=when(operador){
            "*"->valAnt*valAct
            "-"->valAnt-valAct
            else->valAct
        }
        txtresultado.setText(resulx.toString())
        operador=""
    }
}