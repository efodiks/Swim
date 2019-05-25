package michalengel.pwr.application2.view.gallery_view

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentManager
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.synthetic.main.thumbnail_item.view.*
import michalengel.pwr.application2.R


class GalleryScaleAdapter(private val onClickListener: ((Int, View) -> Unit)) : PagedListAdapter<Uri, ThumbnailViewHolder>(
    PathDiffUtil) {

    lateinit var context: Context
    val TAG = "UriPagedListAdapter"


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(
            R.layout.thumbnail_item,
            parent,
            false
        )

        return ThumbnailViewHolder(view) {
            position, v -> onClickListener.invoke(position, v)
            Log.d(TAG, "invoking callback")
        }
    }
    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        Log.d(this::class.java.simpleName, "position: $position")
        holder.bindTo(getItem(position), context)
    }

    object PathDiffUtil : DiffUtil.ItemCallback<Uri>() {
        override fun areItemsTheSame(oldItem: Uri, newItem: Uri): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Uri, newItem: Uri): Boolean {
            return oldItem == newItem
        }
    }
}