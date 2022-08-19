package com.gusoft.planes_rcview_example_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gusoft.planes_rcview_example_project.databinding.RcViewItemBinding
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class PlaneAdapter(private var data: ArrayList<PlaneModel>) :
    RecyclerView.Adapter<PlaneAdapter.ViewHolder>() {

    var onItemClick: (PlaneModel) -> Unit = {}
    var onDeleteClick: (PlaneModel) -> Unit = {}
    var onShowClick: (PlaneModel) -> Unit = {}

    class ViewHolder(val binding: RcViewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RcViewItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planeModel: PlaneModel = data[position]

        val numberFormat = NumberFormat.getCurrencyInstance(Locale("en", "US"))

        holder.binding.apply {
            planeCard.setOnClickListener { onItemClick(planeModel) }
            showButton.setOnClickListener { onShowClick(planeModel) }
            deleteButton.setOnClickListener { onDeleteClick(planeModel) }
            planeName.text = planeModel.name
            planeImage.setImageResource(planeModel.image)
            country.text = "max speed: ${planeModel.country} mph"
            cost.text = "cost: ${numberFormat.format(planeModel.cost)}M"
            speed.text = "max speed: ${planeModel.speed}"
            range.text = "range: ${planeModel.range} miles"
            date.text = "first flight: ${planeModel.date}"
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}