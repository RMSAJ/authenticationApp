package com.example.authenticationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.authenticationapp.R
import com.example.authenticationapp.database.Identity
import com.example.authenticationapp.database.IdentityApp.IdentityApplication
import com.example.authenticationapp.model.IdentityViewModel
import com.example.authenticationapp.model.IdentityViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [AddIdentity.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddIdentity : Fragment() {

private val navigationArgs: DetailFragmentArgs by navArgs()

private val viewModel: IdentityViewModel by activityViewModels{

    IdentityViewModelFactory((activity?.application as IdentityApplication).dataBase
        .identityDao()
        )
    }
    lateinit var identity: Identity

    private var _binding: Fragm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_identity, container, false)
    }


}