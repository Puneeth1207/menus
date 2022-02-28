package com.example.startactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import android.content.Context
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View


import com.example.startactivity.databinding.ActivityPopupMenuBinding

class popup_menuActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityPopupMenuBinding
    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityPopupMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_menu)
       mContext = binding.root.context
        binding.sports.setOnClickListener {
            val popupMenu= PopupMenu(mContext, binding.sports)
            popupMenu.menuInflater.inflate(R.menu.menu_main, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                Toast.makeText(
                    mContext,
                    "You Clicked : " + item.title,
                    Toast.LENGTH_SHORT
                )
                    .show()
                true
            }
            popupMenu.show()

        }
        binding.national.setOnClickListener {
            val popMenu = PopupMenu(mContext, binding.national)

            popMenu.menuInflater.inflate(R.menu.menu_active, popMenu.menu)

            popMenu.setOnMenuItemClickListener { item->  true }

            popMenu.show()
        }

        }
    }

