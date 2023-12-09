package com.example.matchmania

import HighscoreAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matchmania.databinding.FragmentHighscoreBinding

class HighscoreFragment : Fragment() {

    private lateinit var binding: FragmentHighscoreBinding
    private val highscoreViewModel: HighscoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHighscoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi RecyclerView dan adapter
        val adapter = HighscoreAdapter()
        binding.recyclerViewHighscore.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewHighscore.adapter = adapter

        // Observer untuk mengamati perubahan pada data highscores
        highscoreViewModel.highscores.observe(viewLifecycleOwner) { highscoresList ->
            // Update data pada adapter
            adapter.submitList(highscoresList)
        }
    }
}
