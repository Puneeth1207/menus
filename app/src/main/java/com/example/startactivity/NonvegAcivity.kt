package com.example.startactivity

import android.content.Intent
import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
//import android.view.View
//import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
//import android.widget.Toast
import com.example.startactivity.databinding.ActivityNonvegAcivityBinding
//import com.google.android.material.snackbar.Snackbar
import android.content.Context as Context1
import android.view.Menu as Menu1

class NonvegAcivity : AppCompatActivity() {
    private lateinit var binding: ActivityNonvegAcivityBinding
    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      // setContentView(binding.root)
        mContext = binding.root.context

        setContentView(R.layout.activity_nonveg_acivity)
        binding= ActivityNonvegAcivityBinding.inflate(layoutInflater)
        val name= arrayListOf<String>("edwede","ewedwdeeeeffr","weedasad","dqdasxaed")
        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,name
        )
        binding.chicken.adapter=arrayAdapter
        binding.chicken.setOnItemClickListener { parent, view, position, id ->

        }


    }

    override fun onCreateOptionsMenu(menu: Menu1?): Boolean {
        menuInflater.inflate(R.menu.menu_fixing, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent = Intent(mContext, NonvegAcivity::class.java)
        when (item.itemId) {
            R.id.app -> {
                intent = Intent(mContext, NonvegAcivity::class.java)
            }
            R.id.app1 -> {
                intent = Intent(mContext, MainActivity::class.java)
            }
            R.id.app2 -> {
                intent = Intent(mContext, ResipiesActivity::class.java)
            }}
        startActivity(intent)

        return super.onOptionsItemSelected(item)
    }


}