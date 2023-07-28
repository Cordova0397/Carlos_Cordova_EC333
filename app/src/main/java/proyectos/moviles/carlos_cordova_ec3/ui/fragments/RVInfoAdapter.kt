package proyectos.moviles.carlos_cordova_ec3.ui.fragments


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import proyectos.moviles.carlos_cordova_ec3.databinding.ItemInfoBinding
import proyectos.moviles.carlos_cordova_ec3.model.Info

class RVInfoAdapter(var info: List<Info>): RecyclerView.Adapter<InfoVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoVH {
        val binding = ItemInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return InfoVH(binding)
    }

    override fun getItemCount(): Int = info.size

    override fun onBindViewHolder(holder: InfoVH, position: Int) {
        holder.bind(info[position])
    }
}
class  InfoVH(private val binding: ItemInfoBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(info: Info) {
        binding.txtInfoName.text = info.name

        if (info.imgUrl.isNotEmpty()) {
            binding.imgInfo.load(info.imgUrl)
        } else {
            binding.imgInfo.setImageResource(R.drawable.polo)
        if (product.isFavorite) {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_fill)
        } else{
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite)
        }

    }

}