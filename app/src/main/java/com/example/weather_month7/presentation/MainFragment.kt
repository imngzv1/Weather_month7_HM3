package com.example.weather_month7.presentation

import AdapterHours
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather_month7.data.model.WeatherModel
import com.example.weather_month7.data.network.Retrofit
import com.example.weather_month7.databinding.FragmentMainBinding
import com.example.weather_month7.domain.Repository
import kotlin.math.roundToInt


class MainFragment : Fragment() {
    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }
    private val viewModel = MainViewModel(Repository(Retrofit().api))
    private val adapter = AdapterHours(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCity.setOnClickListener {
            chooseCity()
        }

    }

    private fun chooseCity() {

        val builder = AlertDialog.Builder(requireContext())
        val input = EditText(requireContext())
        builder.setTitle("Добавить город")
        builder.setMessage("Выберите город")
        builder.setView(input)
        builder.setPositiveButton("Добавить") { dialog, which ->
            val cityName = input.text.toString()
            viewModel.getCurrentTempVM(cityName).observe(viewLifecycleOwner) { data ->
                data?.let {
                    val temp = it.current.temp_c.roundToInt()
                    binding.tv2.text = "${temp}°"
                    val name = it.location.name.replace("[eyuioaEYUIOA]".toRegex(), "")
                    binding.tv3.text = printWordsTown(name)
                    binding.tv4.text = it.location.name

                    adapter.setData(it.forecast.forecastday.flatMap { it.hour }) // Обновление адаптера с новыми данными

                    binding.recyclerV.adapter = adapter
                    binding.recyclerV.layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                }
            }
            dialog.dismiss()
        }
        builder.setNegativeButton("Отмена") { dialog, which -> dialog.dismiss() }
        builder.show()
    }

    private fun printWordsTown(word: String): String {
        return if (word.length >= 3) {
            "${word[0]}${word[word.length / 2]}${word[word.length - 1]}"
        } else {
            return word
        }
    }
}