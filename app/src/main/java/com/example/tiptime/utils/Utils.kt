package com.example.tiptime.utils
import java.text.NumberFormat

object Utils {
    /**
     * Calculates the tip based on the user input and format the tip amount
     * according to the local currency.
     * Example would be "$10.00".
     */
    fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
        var tip = tipPercent / 100 * amount
        if(roundUp){
            tip = kotlin.math.ceil(tip)
        }
        return NumberFormat.getCurrencyInstance().format(tip)
    }
}