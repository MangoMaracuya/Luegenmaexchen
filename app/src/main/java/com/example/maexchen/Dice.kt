package com.example.maexchen

import kotlin.random.Random

class Dice {
    var die1: Int = 0
    var die2: Int = 0

    fun roll_dice() {
        Random.Default
        die1 = Random.nextInt(1, 6)
        die2 = Random.nextInt(1, 6)
    }

    fun calculate_value(): Int {
        var value = 0
        if (this.die1 < this.die2) {
            value = 10 * die2 + die1;
        } else if (this.die2 < this.die1) {
            value = 10 * die1 + die2
        } else {
            value = 10 * die1 + die2
        }
        return value;
    }
}