package com.example.dicerolller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
           onRoll()
        }
    }

    private fun onRoll():Unit{
        val toast = Toast.makeText(this, "You Won!", Toast.LENGTH_SHORT)

        val rolledVal:Int=Dice(6).rollDice()
        if(rolledVal==6) toast.show()
        val drawableResource = when (rolledVal) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = rolledVal.toString()
    }
}

class Dice(val sides: Int){
    fun rollDice():Int{
        return (1..sides).random()
    }

}