package com.example.authenticationapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.authenticationapp.R
import com.example.authenticationapp.database.Identity
import com.example.authenticationapp.database.IdentityApp.IdentityApplication
import com.example.authenticationapp.databinding.FragmentDetailBinding
import com.example.authenticationapp.model.IdentityViewModel
import com.example.authenticationapp.model.IdentityViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class DetailFragment : Fragment() {

//    private val navigationArgs: DetailFragmentArgs by navArgs()

    private val viewModel: IdentityViewModel by activityViewModels{
        IdentityViewModelFactory((activity?.application as IdentityApplication).dataBase
            .identityDao()
        )
    }
    lateinit var identity: Identity

    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun bind(identity:Identity) {
    binding.apply {
        identityName.text = identity.name
    }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val id =navigationArgs.itemId
        viewModel.retrieveItem().observe(this.viewLifecycleOwner) { it ->
            it.let {
            bind(it)
          //  println(it)
            //    println(id)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}