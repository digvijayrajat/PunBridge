package com.digi.bridge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.digi.modulea.FragmentA
import com.digi.moduleb.FragmentB

class RootFragment : Fragment() {
    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_root, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFragmentA()
        setupFragmentB()
        view.findViewById<Button>(R.id.btn_reset).setOnClickListener {
            fragmentA.processReceivedData("key", "Resetting A")
            fragmentB.processReceivedData("key", "Resetting B")
        }
    }

    private fun setupFragmentA() {
        fragmentA = FragmentA()

        childFragmentManager.beginTransaction()
            .add(R.id.container_A, fragmentA)
            .commit()


        // Set up a listener for FragmentA and pass received data to FragmentB
        fragmentA.registerDataCallback { key, value ->
            fragmentB.processReceivedData(key, value)
        }

    }

    private fun setupFragmentB() {
        fragmentB = FragmentB()

        childFragmentManager.beginTransaction()
            .add(R.id.container_B, fragmentB)
            .commit()


        // Set up a listener for FragmentB and pass received data to FragmentA
        fragmentB.registerDataCallback { key, value ->
            fragmentA.processReceivedData(key, value)
        }

    }
}