package com.digi.modulea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.digi.util.CommunicatorFragment

class FragmentA : CommunicatorFragment() {

    private lateinit var dataReceiver: (key: String, value: Any) -> Unit

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_send_data).setOnClickListener {
            val key = "Key"
            val value = "What do you call a dead green bean? A zom-bean."
            dataReceiver.invoke(key, value)
        }
    }

    override fun processReceivedData(key: String, value: Any) {
        val textView = view?.findViewById<TextView>(R.id.tv_received_data)
        textView?.text = "$value"
    }

    override fun registerDataCallback(callback: (key: String, value: Any) -> Unit) {
        this.dataReceiver = callback
    }
}