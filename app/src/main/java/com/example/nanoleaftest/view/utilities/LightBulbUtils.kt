package com.example.nanoleaftest.view.utilities

object LightBulbUtils {

    /**
     * @param numberOfLightBulbColor Number of light bulb colors in bucket.
     * @param numberOfEachBulbColor Number of light bulb of each color.
     *
     * @return The total number of light bulb in bucket
     */
    fun getTotalNumberOfLightBulbs(
        numberOfLightBulbColor: Int,
        numberOfEachBulbColor :Int
    ) : Long {
        return (numberOfLightBulbColor.toLong() * numberOfEachBulbColor.toLong())
    }

    /**
     * @param numberOfBulbRandomlyPick Number of randomly picked light bulbs from the bucket.
     * @param numberOfLightBulbColor Number of light bulb colors in bucket.
     *
     * @return The list of randomly picked bulbs
     */
    fun getRandomlyPickedBulbList(
        numberOfBulbRandomlyPick: Int,
        numberOfLightBulbColor: Int
    ) : List<Int>{
        return IntArray(numberOfBulbRandomlyPick) { (1..numberOfLightBulbColor).random() }.asList()
    }

    /**
     * @param randomlyPickedList
     * List of randomly picked bulbs
     *
     * @return Number of unique light bulb color from randomly picked bulbs
     */
    fun getNumberOfUniqueBulb(randomlyPickedList: List<Int>):Int {
        var bulbCountMapForEachColor = HashSet<Int>()
        for (i in randomlyPickedList.indices){
            if(!bulbCountMapForEachColor.contains(randomlyPickedList[i])) {
                bulbCountMapForEachColor.add(randomlyPickedList[i])
            }
        }
        return bulbCountMapForEachColor.size
    }

    /**
     * @param totalNumberOfUniqueBulbPicked
     *  Total number of unique bulbs of n number of randomly picked light bulbs
     * @param numberOfTimeSimulationRun
     *  Number of times simulation run
     */
    fun getAverageOutputOfSimulation(
        totalNumberOfUniqueBulbPicked: Int,
        numberOfTimeSimulationRun: Long
    ): Double {
        return totalNumberOfUniqueBulbPicked.toDouble()/numberOfTimeSimulationRun.toDouble()
    }
}