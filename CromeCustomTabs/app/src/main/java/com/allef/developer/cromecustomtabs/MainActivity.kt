package com.allef.developer.cromecustomtabs

import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnoTab.setOnClickListener {
            openTab()


        }
    }


    fun openTab(){
        val url = "http://www.google.com"
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ActivityCompat.getColor(this,R.color.colorPrimary))
        val icon = BitmapFactory.decodeResource(resources,android.R.drawable.ic_menu_agenda)
        val pit = PendingIntent.getActivity(this,0,Intent(this,MainActivity::class.java),0)
        builder.setActionButton(icon,"Ação",pit,true)
        builder.addMenuItem("Menu",pit)
        builder.setStartAnimations(this,android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        builder.setExitAnimations(this,android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        val customtabs = builder.build()
        customtabs.launchUrl(this, Uri.parse(url))
    }

}
