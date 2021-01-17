package com.example.maexchen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.maexchen.Dice

class MainActivity : AppCompatActivity() {
    var dice = Dice()
    var current_value: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll_dice_button = findViewById<Button>(R.id.button_roll_dice)
        val show_hide_button = findViewById<Button>(R.id.button_show_hide)
        val higher_button = findViewById<Button>(R.id.button_higher)
        val value_textview = findViewById<TextView>(R.id.value_textview)


        roll_dice_button.setOnClickListener {
            dice.roll_dice()
            current_value = dice.calculate_value()
            value_textview.text = current_value.toString()
            higher_button.isEnabled = true
        }

        show_hide_button.setOnClickListener {
            if (value_textview.text != "") {
                value_textview.text = ""
                roll_dice_button.isEnabled = false
            } else {
                value_textview.text = current_value.toString()
                roll_dice_button.isEnabled = true
            }
        }

        higher_button.setOnClickListener {
            value_textview.text = ""
            dice.roll_dice()
            current_value = dice.calculate_value()
            higher_button.isEnabled = false
        }
    }
}