package com.example.maexchen

import org.junit.Test

import org.junit.Assert.*
import com.example.maexchen.Dice

class TestDice {
    @Test
    fun test_init() {
        val my_dice = Dice()
        assertEquals(my_dice.die1, 0)
        assertEquals(my_dice.die2, 0)
    }
    @Test
    fun test_roll_dice() {
        val my_dice = Dice();
        my_dice.roll_dice();
        assertTrue(my_dice.die1 != 0);
        assertTrue(my_dice.die2 != 0);
    }
    @Test
    fun test_calculate_value() {
        val my_dice = Dice()
        my_dice.die1 = 1;
        my_dice.die2 = 2;
        assertEquals(my_dice.calculate_value(), Pair(2, 1))
    }
}