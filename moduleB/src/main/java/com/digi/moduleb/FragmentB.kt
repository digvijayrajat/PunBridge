package com.digi.moduleb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.digi.util.CommunicatorFragment

class FragmentB : CommunicatorFragment() {

    private lateinit var dataReceiver: (key: String, value: Any) -> Unit

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_send_data).setOnClickListener {
            val key = "Key"
            val value = "Did you hear about the man who ate a yellow fruit? It’s bananas."
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