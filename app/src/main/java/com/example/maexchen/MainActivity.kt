package com.example.maexchen

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

enum class DieImage() {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX;

    fun to_path(): String {
        return this.name.toLowerCase(Locale.ROOT) + ".png"
    }
}

class MainActivity : AppCompatActivity() {
    var dice: Dice = Dice()
    var current_value: Pair<Int, Int> = Pair(0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll_dice_button = findViewById<Button>(R.id.button_roll_dice)
        val show_hide_button = findViewById<Button>(R.id.button_show_hide)
        val higher_button = findViewById<Button>(R.id.button_higher)

        val left_die_view = findViewById<ImageView>(R.id.left_die_imageview)
        val right_die_view = findViewById<ImageView>(R.id.right_die_imageview)

        roll_dice_button.setOnClickListener {
            dice.roll_dice()
            current_value = dice.calculate_value()
            if (current_value == Pair(2, 1)) {
                
                this.play_maexchen_sound()
            }
            set_image_views(current_value)
            higher_button.isEnabled = true
        }

        show_hide_button.setOnClickListener {
            if (left_die_view.visibility != View.INVISIBLE && right_die_view.visibility != View.INVISIBLE) {
                left_die_view.visibility = View.INVISIBLE
                right_die_view.visibility = View.INVISIBLE
                roll_dice_button.isEnabled = false
            } else {
                left_die_view.visibility = View.VISIBLE
                right_die_view.visibility = View.VISIBLE
                roll_dice_button.isEnabled = true
            }
        }

        higher_button.setOnClickListener {
            left_die_view.visibility = View.INVISIBLE
            right_die_view.visibility = View.INVISIBLE
            dice.roll_dice()
            current_value = dice.calculate_value()
            if (current_value == Pair(2, 1)) {
                this.play_maexchen_sound()
            }
            set_image_views(current_value)
            higher_button.isEnabled = false
        }
    }

    fun set_image_views(value: Pair<Int, Int>) {
        val left_die_view = findViewById<ImageView>(R.id.left_die_imageview)
        val right_die_view = findViewById<ImageView>(R.id.right_die_imageview)
        // left image view
        when (value.first) {
            1 -> left_die_view.setImageResource(R.drawable.one)
            2 -> left_die_view.setImageResource(R.drawable.two)
            3 -> left_die_view.setImageResource(R.drawable.three)
            4 -> left_die_view.setImageResource(R.drawable.four)
            5 -> left_die_view.setImageResource(R.drawable.five)
            6 -> left_die_view.setImageResource(R.drawable.six)
        }
        //right image view
        when (value.second) {
            1 -> right_die_view.setImageResource(R.drawable.one)
            2 -> right_die_view.setImageResource(R.drawable.two)
            3 -> right_die_view.setImageResource(R.drawable.three)
            4 -> right_die_view.setImageResource(R.drawable.four)
            5 -> right_die_view.setImageResource(R.drawable.five)
            6 -> right_die_view.setImageResource(R.drawable.six)
        }
    }

    fun play_maexchen_sound() {
        val media_player = MediaPlayer.create(this, R.raw.maexchen)
        media_player.start()
    }
}