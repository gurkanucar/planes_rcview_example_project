package com.gusoft.planes_rcview_example_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gusoft.planes_rcview_example_project.databinding.RcViewItemBinding

class PlaneAdapter(private var data: ArrayList<PlaneModel>) :
    RecyclerView.Adapter<PlaneAdapter.ViewHolder>() {


    class ViewHolder(val binding: RcViewItemBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RcViewItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planeModel: PlaneModel = data[position]

        holder.binding.apply {
            planeName.text = planeModel.name
            planeImage.setBackgroundResource(planeModel.image)
            country.text = planeModel.country
            cost.text = planeModel.cost.toString()
            speed.text = planeModel.speed.toString()
            range.text = planeModel.range.toString()
            date.text = planeModel.date
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}