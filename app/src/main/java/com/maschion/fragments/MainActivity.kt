package com.maschion.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import com.maschion.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupActionBar()

    }

    private fun setupActionBar() {
        addMenuProvider(object : MenuProvider{

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_home, menu)
            }

            //na seleção do item do menu
            //toda vez que clicar em qualquer item do menu vai chamar essa função
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                when(menuItem.itemId){

                    R.id.action_save -> {
//                        save()
                    }

                    R.id.action_config -> {
                        menuItem.isChecked = !menuItem.isChecked
//                        openSetting()

                    }

                }

                return true
            }

        })
    }

//    private fun openSetting() {
//        TODO("Not yet implemented")
//    }
//
//    private fun save() {
//        TODO("Not yet implemented")
//    }

}