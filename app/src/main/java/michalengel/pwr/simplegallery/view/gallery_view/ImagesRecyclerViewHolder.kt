package michalengel.pwr.simplegallery.view.gallery_view

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.image_recycler_view_item.view.*
import michalengel.pwr.simplegallery.R

class ImagesRecyclerViewHolder(itemView: View, callback: ((Int, View) -> Unit) ) : RecyclerView.ViewHolder(itemView) {
    private var imageView: ImageView = itemView.image
    private val TAG = "ImagesRecyclerViewHolder"

    init {
        itemView.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) callback.invoke(adapterPosition, itemView)
            Log.d(TAG, "item $adapterPosition clicked, callback = $callback")
        }
    }

    fun bindTo(uri: Uri?, context: Context) {
        Log.d(TAG, "binding $uri to $imageView")
            //val it = imageView
            //it.layoutParams.width = Math.round((it.measuredWidth * scale))
            //it.layoutParams.height = Math.round((it.measuredHeight * scale))
        if(uri != null) ViewCompat.setTransitionName(imageView, uri.toString())

        Glide.with(context)
                .load(uri)
                .thumbnail(0.1f)
                .placeholder(R.drawable.ic_photo_primary_24dp)
                .dontAnimate()
                .into(imageView)
    }
}