package com.maschion.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.maschion.fragments.databinding.ActivityMainBinding
import com.maschion.fragments.fragments.HomeFragment
import com.maschion.fragments.fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.home.setOnClickListener {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HomeFragment>(binding.fragmentContainerView.id)
                addToBackStack(null)
            }

        }

        binding.secondButton.setOnClickListener {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SecondFragment>(binding.fragmentContainerView.id)
                addToBackStack(null)
            }

        }

            //pilha de retorno

        binding.showLogs.setOnClickListener {
            showBackStackFragments()

        }

    }

    private fun showBackStackFragments() {
        Log.i("Teste", "##########")
        supportFragmentManager.fragments.forEach {
            Log.i("Teste", it.toString())
        }
    }
}