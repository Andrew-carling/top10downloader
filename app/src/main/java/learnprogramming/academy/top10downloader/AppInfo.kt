package learnprogramming.academy.top10downloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_record.*
import kotlinx.android.synthetic.main.list_record.ivImage
import kotlinx.android.synthetic.main.list_record.tvName
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


        tvName.text = name
        tvArtist.text = artist
        tvSummary.text = summary
        val picasso = Picasso.get()
        picasso.load(image)
            .into(ivImage)




    }
}