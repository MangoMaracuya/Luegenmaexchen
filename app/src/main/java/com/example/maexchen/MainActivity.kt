package com.example.maexchen

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    // Initialize variables:
    lateinit var roll_dice_button:Button
    lateinit var show_hide_button:Button
    lateinit var higher_button:Button

    lateinit var left_die_view:ImageView
    lateinit var right_die_view:ImageView

    // Define variables:
    var dice: Dice = Dice()
    var current_value: Pair<Int, Int> = Pair(0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_dice_button = findViewById(R.id.button_roll_dice)
        show_hide_button = findViewById(R.id.button_show_hide)
        higher_button = findViewById(R.id.button_higher)

        left_die_view = findViewById(R.id.left_die_imageview)
        right_die_view = findViewById(R.id.right_die_imageview)

        init_onclicklisteners()
        
        /* only for testing purposes
        Glide.with(this)
                .load(R.drawable.banana)
                .into(left_die_view)*/
    }

    fun init_onclicklisteners() {

        roll_dice_button.setOnClickListener {
            dice.roll_dice()
            current_value = dice.calculate_value()
            if (current_value == Pair(2, 1)) {

                this.play_maexchen_sound()
            }
            set_image_views(current_value)
            left_die_view.visibility = View.VISIBLE
            right_die_view.visibility = View.VISIBLE
            higher_button.isEnabled = true
        }

        show_hide_button.setOnClickListener {
            if (left_die_view.visibility != View.INVISIBLE && right_die_view.visibility != View.INVISIBLE) {
                left_die_view.visibility = View.INVISIBLE
                right_die_view.visibility = View.INVISIBLE
            } else {
                left_die_view.visibility = View.VISIBLE
                right_die_view.visibility = View.VISIBLE
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