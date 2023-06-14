package com.digi.util

import androidx.fragment.app.Fragment

abstract class CommunicatorFragment : Fragment() {
    abstract fun processReceivedData(key: String, value: Any)
    abstract fun registerDataCallback(callback: (key: String, value: Any) -> Unit)
}