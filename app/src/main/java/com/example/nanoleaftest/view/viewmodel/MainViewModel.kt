package com.example.nanoleaftest.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nanoleaftest.view.utilities.LightBulbUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val averageOutputOfSimulation = MutableLiveData<Double>()
    val averageOutOfSimulationLiveData: MutableLiveData<Double>
    get() = averageOutputOfSimulation

    /**
     * This function will process n number of simulation.
     * @param numberOfLightBulbColor Number of light bulb colors in bucket.
     * @param numberOfEachBulbColor Number of light bulbs of each color in bucket.
     * @param numberOfBulbRandomlyPick Number of randomly picked light bulbs from the bucket.
     * @param numberOfSimulationRun Number of times the simulation will run.
     */
    fun processSimulation(
        numberOfLightBulbColor: Int,
        numberOfEachBulbColor :Int,
        numberOfBulbRandomlyPick: Int,
        numberOfSimulationRun : Long
    ){
        CoroutineScope(Dispatchers.Default).launch {
            var totalNumberOfUniqueBulbFromSimulation = 0
            for ( i in 0 until numberOfSimulationRun) {
                val randomPickedBulbList = LightBulbUtils.getRandomlyPickedBulbList(
                    numberOfBulbRandomlyPick,
                    numberOfLightBulbColor
                )
                totalNumberOfUniqueBulbFromSimulation +=
                    LightBulbUtils.getNumberOfUniqueBulb(randomPickedBulbList)
            }
            averageOutputOfSimulation.postValue(LightBulbUtils.getAverageOutputOfSimulation(
                totalNumberOfUniqueBulbFromSimulation, numberOfSimulationRun
            ))
        }
    }


}