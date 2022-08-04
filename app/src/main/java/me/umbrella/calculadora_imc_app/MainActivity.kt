package me.umbrella.calculadora_imc_app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        Log.w("lifecycle", "No onCreate() - Criando a Tela")
    }

    private fun setListeners() {
        itPeso?.doAfterTextChanged { text ->
            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }

        /*itAltura?.doOnTextChanged { text, 0, 10, 1 ->
            // tvTitle?.text = text
        }*/

        btCalcular?.setOnClickListener {
            calcularIMC(itPeso.text.toString(), itAltura.text.toString())
        }

    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(peso != null && altura != null) {
            val imc = peso / (altura * altura)
            tvTitle.text = "%.2f".format(imc)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "No onStart() - Deixando a Tela Visível")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "No onResume() - Interação com a Tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle", "No onPause() - A Tela Perdeu o Foco. Não pode mais interagir")
    }

    override fun onStop() {
        Log.w("lifecycle", "No onStop() - A Tela não está mais visível. Mas ainda existe")
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle", "No onRestart(). A Tela está Retornando ao Foco")
    }

    override fun onDestroy() {
        Log.w("lifecycle", "No onDestroy() - A Tela Foi Destruida")
        super.onDestroy()
    }
}
