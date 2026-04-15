package com.example.thesisuiresearch

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thesisuiresearch.ui.ProductListActivity
import com.example.thesisuiresearch.ui.theme.ThesisUIResearchTheme

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

