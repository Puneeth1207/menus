package com.example.startactivity

import android.content.Intent
import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.startactivity.databinding.ActivityMainBinding
import com.example.startactivity.databinding.ActivityResipiesBinding

class ResipiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResipiesBinding
    lateinit var mContext: Context



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResipiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = binding.root.context

        val names = arrayListOf<String>("curry", "tcryc", "uguyguy", "uytdty")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, names
        )
        binding.respieslb.adapter = arrayAdapter

        // binding.respieslb.setOnItemClickListener { parent, view, position, id -> }
        //intent = Intent(applicationContext, NonvegAcivity::class.java)
        binding.hello.setOnClickListener {
            startActivity(Intent(it.context, popup_menuActivity::class.java))}
        binding.respieslb.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> {
                    var intent = Intent(applicationContext, NonvegAcivity::class.java)
                    startActivity(intent)
                }
        }
    }}



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_active, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent: Intent = Intent(mContext, ResipiesActivity::class.java)
        when (item.itemId) {
            R.id.act -> {
                intent = Intent(mContext, ResipiesActivity::class.java)
            }
            R.id.acti -> {
                intent = Intent(mContext, MainActivity::class.java)
            }
           R.id.activ -> {
               intent = Intent(mContext, NonvegAcivity::class.java)
            }

            }

        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }





}