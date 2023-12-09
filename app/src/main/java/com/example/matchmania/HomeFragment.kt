package com.example.matchmania

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Tombol Play
        view.findViewById<View>(R.id.btnPlay).setOnClickListener {
                val intent = Intent(activity, GameActivity::class.java)
                startActivity(intent)

                // Kembali ke MainActivity setelah beberapa saat
                Handler(Looper.getMainLooper()).postDelayed({
                    val mainIntent = Intent(activity, MainActivity::class.java)
                    startActivity(mainIntent)
                }, 5000) // 5000 milidetik = 5 detik
        }

        return view
    }
}