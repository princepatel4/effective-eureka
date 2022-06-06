package com.example.nanoleaftest.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nanoleaftest.databinding.ActivityMainBinding
import com.example.nanoleaftest.view.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    var numberOfLightBulbColor : Int = 0
    var numberOfEachBulbColor : Int = 0
    var numberOfBulbRandomlyPick: Int = 0
    var numberOfSimulationRun: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.buttonRunSimulation.setOnClickListener(this)
        setObserver()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.buttonRunSimulation.id -> {
                if(isInputValid()) {
                    numberOfLightBulbColor =
                        binding.editTextLightBulbColors.text.toString().toInt()
                    numberOfEachBulbColor =
                        binding.editTextQuantityOfEachColor.text.toString().toInt()
                    numberOfBulbRandomlyPick =
                        binding.editTextNumberOfRandomlyPick.text.toString().toInt()
                    numberOfSimulationRun =
                        binding.editTextNumberOfTimeSimulationRun.text.toString().toLong()
                    viewModel.processSimulation(
                        numberOfLightBulbColor = numberOfLightBulbColor,
                        numberOfEachBulbColor = numberOfEachBulbColor,
                        numberOfBulbRandomlyPick = numberOfBulbRandomlyPick,
                        numberOfSimulationRun = numberOfSimulationRun
                    )
                }
            }
        }
    }

    //Setup live data observer
    private fun setObserver() {
        viewModel.averageOutOfSimulationLiveData.observe(this, Observer {averageOutput->
            binding.textViewSimulationResult.text = String.format("%.2f", averageOutput)
        })
    }

    //Validate if user input are valid before proceeding further
    private fun isInputValid() : Boolean{
        if (binding.editTextLightBulbColors.text.toString().toLong()<=1){
            binding.editTextLightBulbColors.error = "Please enter number of light color"
            return false
        }
        if (binding.editTextQuantityOfEachColor.text.toString().toLong()<0){
            binding.editTextQuantityOfEachColor.error = "Please enter quantity of each light color"
            return false
        }
        if (binding.editTextNumberOfRandomlyPick.text.toString().toLong()<0){
            binding.editTextNumberOfRandomlyPick.error = "Please enter number of randomly picked light color"
            return false
        }
        if (binding.editTextNumberOfTimeSimulationRun.text.toString().toLong()<1000){
            binding.editTextNumberOfTimeSimulationRun.error = "Please enter number of simulation greater than 1000"
            return false
        }
        return true
    }
}