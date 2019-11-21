package com.example.dbase

import android.content.Context
import android.content.Context.TELEPHONY_SERVICE
import android.telephony.TelephonyManager
import java.util.*


fun getCountryCode(context: Context): String {
    var code = ""
    val manager = context.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
    val arrayCodes = context.resources.getStringArray(R.array.CountryCodes)
    for (i in arrayCodes.indices) {
        val arrayCode = arrayCodes[i].split(",")
        if (arrayCode[1].trim () == manager.simCountryIso.trim().toUpperCase(Locale.getDefault())) {
            code = arrayCode[0]
            break
        }
    }
    return code
}