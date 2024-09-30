package com.plcoding.coroutinesmasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.plcoding.coroutinesmasterclass.sections.coroutine_contexts.main_safety.BitmapCompressor
import com.plcoding.coroutinesmasterclass.sections.coroutine_contexts.main_safety.PhotoPickerScreen
import com.plcoding.coroutinesmasterclass.ui.theme.CoroutinesMasterclassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        lifecycleScope.launch {
//            val job = launch {
//                delay(2000)
//                println("##### coroutines finished")
//            }
//
//            delay(1000L)
//            job.cancel()
//            println("##### coroutines cancelled")
//        }

        val compressor = BitmapCompressor(applicationContext)

        setContent {
            CoroutinesMasterclassTheme {
                PhotoPickerScreen(compressor = compressor)
            }
        }
    }
}