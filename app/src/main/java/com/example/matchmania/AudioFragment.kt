package com.example.matchmania

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch

class AudioFragment : Fragment() {

    private lateinit var switchAudio: Switch
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio, container, false)

        // Inisialisasi SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        // Inisialisasi UI
        switchAudio = view.findViewById(R.id.switchAudio)

        // Set status awal dari SharedPreferences
        switchAudio.isChecked = sharedPreferences.getBoolean("isAudioOn", true)

        // Handle perubahan pada switch audio
        switchAudio.setOnCheckedChangeListener { _, isChecked ->
            // Simpan status audio ke SharedPreferences
            with(sharedPreferences.edit()) {
                putBoolean("isAudioOn", isChecked)
                apply()
            }
        }

        return view
    }
}