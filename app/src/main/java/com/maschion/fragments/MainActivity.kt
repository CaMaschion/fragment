package com.maschion.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.maschion.fragments.databinding.ActivityMainBinding
import com.maschion.fragments.fragments.HomeFragment
import com.maschion.fragments.fragments.LifecycleFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<LifecycleFragment>(R.id.fragmentContainerView)
            }
        }
    }
}