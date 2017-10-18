package vip.frendy.demobanner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import vip.frendy.kbanner.KBBanner
import kotlin.collections.ArrayList

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

        val images = ArrayList<String>()
        val titles = ArrayList<String>()
        val labels = ArrayList<String>()
        val res = arrayListOf<Int>(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        for (item in items) {
            images.add(item.image)
            titles.add(item.title)
            labels.add(item.label)
        }


        banner.setAdapter(KBBanner.Adapter<ImageView, String> { banner, view, image, position ->
            Glide.with(this).load(image).centerCrop().into(view)
        })
        banner.setDelegate(KBBanner.Delegate<ImageView, String> { banner, view, image, position ->

        })
        banner.setData(images, titles, labels)


        banner2.setAdapter(KBBanner.Adapter<ImageView, Int> { banner, view, imageId, position ->
            Glide.with(this).load(imageId).centerCrop().into(view)
        })
        banner2.setDelegate(KBBanner.Delegate<ImageView, Int> { banner, view, imageId, position ->
            toast("Image Pos = $position")
        })
        banner2.setAutoPlayAble(false)
        banner2.setData(res, null, null)
    }
}