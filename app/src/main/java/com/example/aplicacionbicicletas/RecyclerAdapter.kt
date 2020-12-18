package com.example.aplicacionbicicletas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layaout2.view.*

class RecyclerAdapter(
        val context: Context,
        val listaBicicletas:List<Bicicletas>,
): RecyclerView.Adapter<BaseViewHolder<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return BicicletasViewH(LayoutInflater.from(context).inflate(R.layout.layaout2,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        if(holder is BicicletasViewH){
            holder.bind(listaBicicletas[position],position)
        } else{
            throw IllegalArgumentException("fallo")

        }
    }

    override fun getItemCount(): Int {
        return listaBicicletas.size
    }
    inner class BicicletasViewH(itemView: View):BaseViewHolder<Bicicletas>(itemView){
        override fun bind(iten: Bicicletas, position: Int) {
            Glide.with(context).load(iten.imagen).into(itemView.imagen)
            itemView.nombre.text=iten.modelo
            itemView.año.text = iten.año.toString()
            itemView.empresa.text =iten.empresa
            itemView.precio.text = iten.precio.toString()

        }
    }
}