package com.example.matchmania

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch

class DarkModeFragment : Fragment() {

    private lateinit var switchDarkMode: Switch
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dark_mode, container, false)

        // Inisialisasi SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        // Inisialisasi UI
        switchDarkMode = view.findViewById(R.id.switchDarkMode)

        // Set status awal dari SharedPreferences
        switchDarkMode.isChecked = sharedPreferences.getBoolean("isDarkModeOn", false)

        // Handle perubahan pada switch dark mode
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            // Simpan status dark mode ke SharedPreferences
            with(sharedPreferences.edit()) {
                putBoolean("isDarkModeOn", isChecked)
                apply()
            }
        }

        return view
    }
}