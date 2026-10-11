package org.insbaixcamp.lanzadordados

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Evita que el contenido quede bajo las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { view, insets ->
            val barras = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or
                        WindowInsetsCompat.Type.displayCutout()
            )

            view.setPadding(
                barras.left,
                barras.top,
                barras.right,
                barras.bottom
            )

            insets
        }

        // Buscamos los elementos que hemos creado en el XML
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnLanzar = findViewById<Button>(R.id.btnLanzar)

        // Este bloque se ejecuta cada vez que pulsamos el botón
        btnLanzar.setOnClickListener {
            val numero = (1..6).random()
            txtResultado.text = numero.toString()
        }
    }
}