package learnprogramming.academy.top10downloader

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_record.*
import kotlinx.android.synthetic.main.list_record.ivImage
import kotlinx.android.synthetic.main.list_record.tvName
import kotlinx.android.synthetic.main.list_record.view.*
import kotlinx.android.synthetic.main.record_detail.*

class AppInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.record_detail)

        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val image = bundle?.getString("image")
        val artist = bundle?.getString("artist")
        val summary = bundle?.getString("summary")
        val link = bundle?.getString("link")


        tvName.text = name
        tvArtist.text = artist
        tvSummary.text = summary
        val picasso = Picasso.get()
        picasso.load(image)
            .into(ivImage)


        if (link != null) {
            bu1.setOnClickListener {

                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("$link")
                startActivity(openURL)

            }
        } else {
            bu1.visibility = View.GONE
        }


    }
}