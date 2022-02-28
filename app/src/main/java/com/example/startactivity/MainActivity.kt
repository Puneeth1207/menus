package com.example.startactivity

import android.content.Intent
import  android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.startactivity.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import android.content.Context as Context1

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding
    lateinit var mContext: Context1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = binding.root.context
        val spin = arrayOf("am", "sa", "in", "we", "zm", "aus")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item, spin
        )
        binding.states.adapter = adapter
        intent = Intent(applicationContext, ResipiesActivity::class.java)

        binding.resab.setOnClickListener { startActivity(intent) }

        binding.spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                val capital: String = when (position) {
                    0 -> "sadew"
                    1 -> "dearw"
                    2 -> "trsdf"
                    3 -> "jhgjhgj"
                    4 -> "Sydnehdfsdfsdfy"
                    5 -> "sdfd"
                    6 -> "Morning"
                    else -> "dummy"
                }
                Snackbar.make(view, "Capital is $capital", Snackbar.LENGTH_SHORT).show()

                Toast.makeText(
                    binding.spin.context,
                    "${binding.spin.selectedItem}  ${binding.spin.selectedItemId} $position $id",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.states.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    binding.spin.context,
                    "${binding.states.selectedItem}  ${binding.states.selectedItemId} $position $id",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        Log.e(TAG, "onCreate")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)


    }
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val register = menu!!.findItem(R.id.menu_settings)
        register.isVisible = false //userRegistered is boolean, pointing if the user has registered or not.
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent = Intent(mContext, MainActivity::class.java)
        when (item.itemId) {
            R.id.menu_settings -> {
                intent = Intent(mContext, MainActivity::class.java)
            }
            R.id.submenu_item1 -> {
                intent = Intent(mContext, NonvegAcivity::class.java)
            }
            R.id.submenu_item2 -> {
                intent = Intent(mContext, ResipiesActivity::class.java)
            }}
        startActivity(intent)

return super.onOptionsItemSelected(item)

        }
    }





