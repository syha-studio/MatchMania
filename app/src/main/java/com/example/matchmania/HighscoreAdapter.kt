import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.matchmania.HighscoreItem
import com.example.matchmania.databinding.ItemHighscoreBinding

class HighscoreAdapter : ListAdapter<HighscoreItem, HighscoreAdapter.HighscoreViewHolder>(HighscoreDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighscoreViewHolder {
        val binding = ItemHighscoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HighscoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HighscoreViewHolder, position: Int) {
        val currentHighscore = getItem(position)
        holder.bind(currentHighscore)
    }

    class HighscoreViewHolder(private val binding: ItemHighscoreBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(highscore: HighscoreItem) {
            binding.playerNameTextView.text = highscore.playerName
            binding.scoreTextView.text = highscore.score.toString()
        }
    }

    private class HighscoreDiffCallback : DiffUtil.ItemCallback<HighscoreItem>() {
        override fun areItemsTheSame(oldItem: HighscoreItem, newItem: HighscoreItem): Boolean {
            return oldItem.playerName == newItem.playerName
        }

        override fun areContentsTheSame(oldItem: HighscoreItem, newItem: HighscoreItem): Boolean {
            return oldItem == newItem
        }
    }
}