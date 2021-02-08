package learnprogramming.academy.top10downloader

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_record.view.*


class ViewHolder(v: View) {
    val tvName: TextView = v.findViewById(R.id.tvName)
    val ivImage: ImageView = v.findViewById(R.id.ivImage)


}

class FeedAdapter(
    context: Context,
    private val resource: Int,
    private val applications: List<FeedEntry>


) : ArrayAdapter<FeedEntry>(context, resource) {

    private val TAG = "FeedAdapter"
    private val inflater = LayoutInflater.from(context)



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {

            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {

            view = convertView
            viewHolder = view.tag as ViewHolder
        }

//
//        val tvName: TextView = view.findViewById(R.id.tvName)
//        val tvArtist:  TextView = view.findViewById(R.id.tvArtist)
//        val tvSummary: TextView = view.findViewById(R.id.tvSummary)


        val currentApp = applications[position]

        viewHolder.tvName.text = currentApp.name





        val picasso = Picasso.get()
        picasso.load(currentApp.imageURL)
            .into(viewHolder.ivImage)




            view.ivImage.setOnClickListener {
                val intent = Intent(context, AppInfo::class.java)
                intent.putExtra("name", currentApp.name)
                intent.putExtra("image", currentApp.imageURL)
                intent.putExtra("artist", currentApp.artist)
                intent.putExtra("summary", currentApp.summary)
                context.startActivity(intent)
            }


            return view


    }

    override fun getCount(): Int {

        return applications.size
    }
}


