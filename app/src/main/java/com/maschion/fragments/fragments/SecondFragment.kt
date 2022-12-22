package com.maschion.fragments.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.maschion.fragments.R
import com.maschion.fragments.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val name = binding.edtName.text.toString()
            val age = binding.edtAge.text.toString()

            submitInfoToFragment(name, age)

        }
    }

    private fun submitInfoToFragment(name: String, age: String) {
        val bundle = bundleOf(
            "USER" to User(name, age)
        )

        //****passando dados para o fragment result, pra isso *****

        //preciso substituir o fragment atual (SecondFragment) no nosso host (MainActivity), dentro do container
        // no fragmentContainerView. Como acesso o FragmentManager do host dentro de um fragment?
        parentFragmentManager.commit {

            setReorderingAllowed(true)
            replace<ResultFragment>(R.id.fragmentContainerView, args = bundle)
            addToBackStack(null)
        }

    }

}