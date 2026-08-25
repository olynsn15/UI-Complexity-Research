package com.example.thesisuiresearch.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.thesisuiresearch.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnVar1).setOnClickListener {
            openVariant(1)
        }

        findViewById<Button>(R.id.btnVar2).setOnClickListener {
            openVariant(2)
        }

        findViewById<Button>(R.id.btnVar3).setOnClickListener {
            openVariant(3)
        }
    }

    private fun openVariant(variant: Int) {
        val intent = Intent(this, ProductListActivity::class.java)
        intent.putExtra("variant", variant)
        startActivity(intent)
    }
}

