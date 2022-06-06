package com.example.nanoleaftest

import com.example.nanoleaftest.view.utilities.LightBulbUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LightBulbUtilsTest{
    private var numberOfLightBulbColor : Int = 5
    private var numberOfEachBulbColor : Int = 100

    @Test
    fun totalNumberOfLightBulb() {
        assertEquals(
            500,
            LightBulbUtils.getTotalNumberOfLightBulbs(numberOfLightBulbColor, numberOfEachBulbColor))
    }

    @Test
    fun randomLyPickedList() {
        assertEquals(6, LightBulbUtils.getRandomlyPickedBulbList(6, numberOfLightBulbColor).size)
    }

    @Test
    fun numberOfUniqueBulbs() {
        assertEquals(
            1,
            LightBulbUtils.getNumberOfUniqueBulb(listOf(1,1,1,1,1,1))
        )
    }
}