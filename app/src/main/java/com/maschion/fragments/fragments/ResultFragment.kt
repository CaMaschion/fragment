package com.maschion.fragments.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maschion.fragments.databinding.FragmentResultBinding

class ResultFragment: Fragment() {

    private lateinit var binding: FragmentResultBinding

    //pegando dados do fragment

//    private lateinit var name: String
//    private lateinit var age: String

    private lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            //como acessar o bundle

        val arguments = requireArguments()

//        this.name = arguments.getString("USER_NAME", "")
//        this.age = arguments.getString("USER_AGE", "")

        this.user = arguments.getSerializable("USER") as User
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView2.text = "Nome: {$user.name}, Idade: {$user.age}"
    }

}