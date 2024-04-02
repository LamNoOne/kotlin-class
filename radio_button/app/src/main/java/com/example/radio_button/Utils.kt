package com.example.radio_button

import android.content.Context
import android.net.ConnectivityManager

class Utils {
    companion object {
        fun isOnline(context: Context): Boolean {
            val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = manager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}