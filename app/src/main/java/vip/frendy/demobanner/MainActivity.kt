package vip.frendy.demobanner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
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
        val views = arrayListOf<View>(
                View.inflate(this, R.layout.item_banner, null),
                View.inflate(this, R.layout.item_banner, null),
                View.inflate(this, R.layout.item_banner, null),
                View.inflate(this, R.layout.item_banner, null))

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
        banner.setData(images, null, null)


        banner2.setAdapter(KBBanner.Adapter<View, Int> { banner, view, imageId, position ->
            val imageView = view.findViewById(R.id.image) as ImageView
            Glide.with(this).load(R.mipmap.ic_launcher).centerCrop().into(imageView)
        })
        banner2.setDelegate(KBBanner.Delegate<View, Int> { banner, view, imageId, position ->
            toast("Image Pos = $position")
        })
        banner2.setAutoPlayAble(true)
        banner2.setViews(views)
    }
}