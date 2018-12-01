package com.kausthubh.basis.misc.utils

class MiscUtils {

    /**
     * Calculate Percentage
     */
    fun calculatePercentage(current: Int, length: Int): Int {
        return ((current + 1) * 100) / (length + 1)
    }

}