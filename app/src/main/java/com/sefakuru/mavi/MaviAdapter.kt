package com.sefakuru.mavi

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MaviAdapter(private  val mContext:Context,private val verilerListesi:List<Veriler>)
    :RecyclerView.Adapter<MaviAdapter.cardTasarimNesneleriTutucu>() {
    //sadece sınıf içinde kullanılldıgı için private
    //mcontext androide ozgu verilere erişmemize yarıyor.Liste yapısı kullanılacagı için liste tanımladık
    inner class cardTasarimNesneleriTutucu(view: View) : RecyclerView.ViewHolder(view) {
        var gorselMavi: ImageView  //tasarımla aynı idlerde olması bizim için avantaj
        var bilgiMavi: TextView
        var modelMavi: TextView
        var bedenMavi: TextView
        var fiyatMavi:TextView

        init {//constructor,hangi gorsel nesneye erişileceği burada belirleniyor
            gorselMavi =view.findViewById(R.id.imageMavi)
            bilgiMavi=view.findViewById(R.id.bilgiMavi)
            modelMavi=view.findViewById(R.id.bedenMavi)
            bedenMavi=view.findViewById(R.id.bedenMavi)
            fiyatMavi=view.findViewById(R.id.fiyatMavi)



        }
    }     //gorsel nesnelere erişmek iöçin kullanılır.View sayesinde gorsel nesmnelere erişiriz

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimNesneleriTutucu {//gorsel tasarımı yazılımsal tasarım ile birleştirdik,false diyerek uzerine bir şey ekleme dedik
      val tasarim=LayoutInflater.from(mContext).inflate(R.layout.mavi_urun,parent,false)
        return cardTasarimNesneleriTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return verilerListesi.size  //listenin boyutunuı ekleriz
    }

    override fun onBindViewHolder(holder: cardTasarimNesneleriTutucu, position: Int) {//yazı resim buton gibi özelliklere işlevsellik katiyoruz
       val urun=verilerListesi[position]
        holder.bilgiMavi.text=urun.bilgi
        holder.modelMavi.text=urun.model
        holder.bedenMavi.text=urun.beden
        holder.fiyatMavi.text="${urun.fiyat}"
        holder.gorselMavi.setImageResource(mContext.resources.getIdentifier(urun.resim,"drawable",mContext.packageName))

    }
}