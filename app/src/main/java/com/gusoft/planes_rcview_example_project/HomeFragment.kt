package com.gusoft.planes_rcview_example_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.gusoft.planes_rcview_example_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var list: ArrayList<PlaneModel>
    private lateinit var planeAdapter: PlaneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = generateItems()
        planeAdapter = PlaneAdapter(list)
        binding.apply {
            planesRcView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            planesRcView.adapter = planeAdapter
            planesRcView.setHasFixedSize(true)
        }

        planeAdapter.onItemClick = ::onItemClick
        planeAdapter.onDeleteClick = ::onDeleteClick
        planeAdapter.onShowClick = ::onShowClick

        binding.planesRcView.adapter = planeAdapter

    }


    private fun generateItems(): ArrayList<PlaneModel> {
        val list: ArrayList<PlaneModel> = ArrayList<PlaneModel>()
        list.add(PlaneModel("Hurkus - KT1T", R.drawable.kt1t, "TR", 40.0, 356, 708, "2013"))
        list.add(PlaneModel("F16", R.drawable.f16, "US", 80.0, 1500, 2000, "1979"))
        list.add(PlaneModel("F18", R.drawable.f18, "US", 65.0, 1190, 1000, "1978"))
        list.add(PlaneModel("F35", R.drawable.f35, "US", 130.0, 1200, 670, "2006"))
        list.add(PlaneModel("L39", R.drawable.l39, "US", 0.25, 500, 1200, "1968"))
        list.add(PlaneModel("SU57", R.drawable.su57, "RU", 40.0, 1320, 930, "2010"))
        list.add(PlaneModel("T38", R.drawable.t38, "US", 0.8, 850, 1100, "1959"))
//        list.add(PlaneModel("Eurofighter Typhoon", R.drawable.eurofighter, "EU", 25.0, 360, 1200, "2014"))
//        list.add(PlaneModel("Dassault Rafale", R.drawable.rafale, "FR", 25.0, 360, 1200, "2014"))
//        list.add(PlaneModel("Mustang P51", R.drawable.p51, "US", 25.0, 360, 1200, "2014"))
//        list.add(PlaneModel("F22", R.drawable.f22, "US", 25.0, 360, 1200, "2014"))

        return list
    }


    fun onItemClick(planeModel: PlaneModel) {
        Toast.makeText(
            requireContext(),
            "Item Clicked -> $planeModel", Toast.LENGTH_SHORT
        )
            .show()
    }

    fun onDeleteClick(planeModel: PlaneModel) {
//        Toast.makeText(
//            requireContext(),
//            "Delete Clicked -> $planeModel", Toast.LENGTH_SHORT
//        )
//            .show()
        val index = list.indexOf(planeModel)
        list.removeAt(index)
        planeAdapter.notifyItemRemoved(index)
    }

    fun onShowClick(planeModel: PlaneModel) {
//        Toast.makeText(
//            requireContext(),
//            "Show Clicked -> $planeModel", Toast.LENGTH_SHORT
//        )
//            .show()

        val bundle = Bundle()
        bundle.putParcelable("planeModel", planeModel)
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}