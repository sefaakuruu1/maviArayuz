package com.sefakuru.mavi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sefakuru.mavi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim1:ActivityMainBinding
private lateinit var urunlerArrayList:ArrayList<Veriler>
private lateinit var adapter: MaviAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim1= DataBindingUtil.setContentView(this,R.layout.activity_main)
       tasarim1.recyclerView.setHasFixedSize(true)
        tasarim1.recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

     val u1=Veriler("beyaz_gomlek","En Yeni","Parker Beyaz Jean Gomlek","Oversize/Geniş Kesim",659.99)
     val u2=Veriler("kahverengi_gomlek","Yeni","Blok Renkli Denim Gomlek","Loose Fit/Bol Rahat Kesim",749.99)
     val u3=Veriler("lila_gomlek","En Yeni","Mor Denim Gomlek","Loose Fit/Bol Rahat Kesim",489.99)
     val u4=Veriler("siyah_gomlek","Mavi Pro","Fermuarlı Siyah Denim Gomlek","Loose Fit/Bol Rahat Kesim",649.99)


        urunlerArrayList=ArrayList<Veriler>()
        urunlerArrayList.add(u1)
        urunlerArrayList.add(u2)
        urunlerArrayList.add(u3)
        urunlerArrayList.add(u4)

        adapter=MaviAdapter(this,urunlerArrayList)
        tasarim1.recyclerView.adapter=adapter


    }
}