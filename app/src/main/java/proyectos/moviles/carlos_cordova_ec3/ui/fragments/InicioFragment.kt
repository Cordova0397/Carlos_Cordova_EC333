package proyectos.moviles.carlos_cordova_ec3.ui.fragments

import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import proyectos.moviles.carlos_cordova_ec3.R
import proyectos.moviles.carlos_cordova_ec3.databinding.FragmentInicioBinding
import proyectos.moviles.carlos_cordova_ec3.model.getData


class InicioFragment : Fragment() {
    private lateinit var binding: FragmentInicioBinding
    private lateinit var viewModel: InicioViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInicioBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVInfoAdapter(listOf())
        binding.rvInfo.adapter = adapter
        binding.rvInfo.layoutManager = GridLayoutManager(requireContext(),2,RecyclerView.VERTICAL,false)
        viewModel.info.observe(requireActivity()) { info ->
            adapter.info = info
            adapter.notifyDataSetChanged()
        }
        viewModel.getInfoFromService()
    }
}


