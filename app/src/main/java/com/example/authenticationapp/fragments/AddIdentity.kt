package com.example.authenticationapp.fragments

import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.authenticationapp.R
import com.example.authenticationapp.database.Identity
import com.example.authenticationapp.database.IdentityApp.IdentityApplication
import com.example.authenticationapp.databinding.FragmentAddIdentityBinding
import com.example.authenticationapp.model.IdentityViewModel
import com.example.authenticationapp.model.IdentityViewModelFactory
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class AddIdentity : Fragment() {

    var count = 1
//    private val navigationArgs: DetailFragmentArgs by navArgs()

    private val viewModel: IdentityViewModel by activityViewModels {
        IdentityViewModelFactory(
            (activity?.application as IdentityApplication).dataBase
                .identityDao()
        )
    }
    lateinit var identity: Identity

    private var _binding: FragmentAddIdentityBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddIdentityBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun bind(identity: Identity) {
        binding.apply {
            nameInserted.text
        }
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.nameInserted.text.toString()
        )
    }

    private fun addNewIdentity() {
        if (isEntryValid()) {
            viewModel.addNewIdentity(
                binding.nameInserted.text.toString()
            )
            val action = AddIdentityDirections.actionAddIdentityToDetailFragment()
            findNavController().navigate(action)
            count++
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.save.setOnClickListener {
            addNewIdentity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.

        _binding = null
    }

}