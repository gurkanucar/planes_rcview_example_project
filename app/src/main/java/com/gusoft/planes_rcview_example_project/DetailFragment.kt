package com.gusoft.planes_rcview_example_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gusoft.planes_rcview_example_project.databinding.FragmentDetailBinding
import java.text.NumberFormat
import java.util.*

class DetailFragment : Fragment() {


    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numberFormat = NumberFormat.getCurrencyInstance(Locale("en", "US"))

        val planeModel: PlaneModel = arguments?.get("planeModel") as PlaneModel

        binding.apply {
            deleteButton.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Delete Clicked -> $planeModel", Toast.LENGTH_SHORT
                )
                    .show()
            }
            planeName.text = planeModel.name
            image.setImageResource(planeModel.image)
            country.text = "max speed: ${planeModel.country} mph"
            cost.text = "cost: ${numberFormat.format(planeModel.cost)}M"
            speed.text = "max speed: ${planeModel.speed}"
            range.text = "range: ${planeModel.range} miles"
            date.text = "first flight: ${planeModel.date}"
        }

    }

    override fun onDestroy() {
        super.onDestroy()

    }

}