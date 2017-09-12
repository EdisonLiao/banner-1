package vip.frendy.demobanner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import vip.frendy.kbanner.KBBanner
import java.util.*

/**
 * Created by iiMedia on 2017/9/12.
 */
class MainActivity: AppCompatActivity() {
    val DEFAULT_IMAGE = "http://upload-images.jianshu.io/upload_images/6306778-a7f87bf828053a7d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ArrayList<Item>()
        for(i in 0..4) {
            items.add(Item(DEFAULT_IMAGE, "TEST ${i}", "广告"))
        }

        banner.setAdapter(KBBanner.Adapter<ImageView, String> { banner, view, image, position ->
            view.loadImage(image)
        })

        banner.setDelegate(KBBanner.Delegate<ImageView, String> { banner, view, image, position ->

        })

        val images = ArrayList<String>()
        val titles = ArrayList<String>()
        val labels = ArrayList<String>()
        for (item in items) {
            images.add(item.image)
            titles.add(item.title)
            labels.add(item.label)
        }
        banner.setData(images, titles, labels)
    }

    fun ImageView.loadImage(url: String) {
        Glide.with(context).load(url).centerCrop().into(this)
    }
}