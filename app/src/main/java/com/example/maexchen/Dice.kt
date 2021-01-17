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

    fun calculate_value(): Pair<Int, Int> {
        return when {
            (this.die1 < this.die2) -> Pair(this.die2, this.die1)
            (this.die2 < this.die1) -> Pair(this.die1, this.die2)
            else -> Pair(this.die1, this.die2)
        }
    }
}