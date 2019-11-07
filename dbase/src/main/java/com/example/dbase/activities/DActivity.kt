package com.example.dbase.activities

import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dbase.InternetBroadcastReceiver

abstract class DActivity : AppCompatActivity(),
    InternetBroadcastReceiver.OnInternetConnectionChangeListener {

    private var intentFilter: IntentFilter? = null
    private var receiver: InternetBroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Activity Lifecycle", javaClass.simpleName + "=======> onCreate")
        intentFilter = IntentFilter()
        intentFilter!!.addAction(InternetBroadcastReceiver.CONNECTIVITY_ACTION)
        receiver = InternetBroadcastReceiver()
        receiver!!.setOnInternetConnectionChangeListener(this)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity Lifecycle", javaClass.simpleName + "=======> onResume")
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        Log.i("Activity Lifecycle", javaClass.simpleName + "=======> onPause")
        unregisterReceiver(receiver)
    }

    override fun onStop() {
        super.onStop()
        Log.i("Activity Lifecycle", javaClass.simpleName + "=======> onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Activity Lifecycle", javaClass.simpleName + "=======> onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Activity Lifecycle", javaClass.simpleName + "=======> onRestart")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.i("Activity Lifecycle", javaClass.simpleName + "=======> onPostResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity Lifecycle", javaClass.simpleName + "=======> onDestroy")
    }

    override fun onDisconnected() {
        onInternetDisconnect()
    }

    override fun onConnected() {
        onInternetConnect()
    }

    abstract fun onInternetDisconnect()

    abstract fun onInternetConnect()
}