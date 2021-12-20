package JsonExample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.example.retrofit.R
import kotlinx.android.synthetic.main.json_item.view.*

class JsonAdapter(private val context: Context) : RecyclerView.Adapter<JsonAdapter.ViewHolder>() {
    // private val jsonList: MutableList<Photo>
    var jsonList = mutableListOf<Photo>()


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.json_image
        val title : TextView = itemView.json_title
        val id : TextView = itemView.json_id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.json_item , parent , false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = jsonList[position]

        holder.id.text = item.id
        holder.title.text = item.title

        val imageUrl = GlideUrl(
            item.url, LazyHeaders.Builder()
                .addHeader("User-Agent", "5")
                .build())

        Glide.with(context)
            .load(imageUrl)
            .apply(RequestOptions().centerCrop())
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return if (jsonList.size> 11) {
            18
        } else
            jsonList.size
    }


}