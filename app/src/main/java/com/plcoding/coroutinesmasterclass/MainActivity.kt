package com.plcoding.coroutinesmasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.plcoding.coroutinesmasterclass.sections.coroutine_contexts.main_safety.BitmapCompressor
import com.plcoding.coroutinesmasterclass.ui.theme.CoroutinesMasterclassTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val customScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        lifecycleScope.launch {
          /*  val job = launch {
                val innerJob1 = launch {
                    delay(2000L)
                    println("#### Inner job1 finished")
                }

                val innerJob2 = launch {
                    delay(2000L)
                    println("#### Inner job2 finished")
                }

            }

            delay(1000L)
            job.cancel()
            println("#### job cancelled")*/
//        }

        customScope.launch {
            delay(2000L)
            println("Job finished!")
        }

        lifecycleScope.launch {
            delay(1000L)
//            customScope.cancel()
            customScope.coroutineContext.cancelChildren()
            customScope.launch {
                println("Hello World!")
            }
        }

        val compressor = BitmapCompressor(applicationContext)

        setContent {
            CoroutinesMasterclassTheme {
//                PhotoPickerScreen(compressor = compressor)
            }
        }
    }
}