package com.example.diceroller

/**
 * Laboratorio 4 Parte 2
 *
 * Diego E. Lemus L. - 21469
 * Programacion de Plataformas Moviles - secc 20
 *
 * version 15/08/2022
 */

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Actividad Main
 */
class MainActivity : AppCompatActivity() {

    /**
     * Funcion para la cracion de la actividad
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Encontrar el Button en el layout
        val rollButton: Button = findViewById(R.id.button)

        //Accion del dado al darle click al Button
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Funcion para girar el dado y actualizar el resultado en pantalla
     */
    private fun rollDice() {
        //Crear un objeto Dado con 6 caras y girar el dado
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Encontrar la ImageView en el layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determina que recurso de imagen se usara basado en el giro del dado
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Actualiza la ImageView con la imagen correspondiente
        diceImage.setImageResource(drawableResource)

        //Actualiza la descripcion del contenido
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Clase dado donde se describe su numero de caras
 */
class Dice(private val numSides: Int) {

    /**
     * Dado random
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}
