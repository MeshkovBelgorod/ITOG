package dev.meshkov.sergey

import android.content.Context

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.meshkov.sergey.R
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView

class Adapter(context: Context, actions: MutableList<ModelRV>, fragment: SecondFragment) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    var actions: MutableList<ModelRV>
    var context: Context
    var inflater: LayoutInflater
    var fragment: SecondFragment

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item, parent, false)
        return ViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //получаем обьект из списка по его порядковому номеру
        val (name, path) = actions[position]
        holder.name.text = name
        //
        holder.linearLayout.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(path))
            fragment.requireActivity().startActivity(browserIntent)
        }
    }

    override fun getItemCount(): Int {
        return actions.size
    }

    class ViewHolder(itemView: View, context: Context?) : RecyclerView.ViewHolder(itemView) {
        //ViewHolder содержит в себе информацию о виде элемента списка
        val name: TextView
        val linearLayout: CardView
        init {
            name = itemView.findViewById<View>(R.id.name) as TextView
            linearLayout = itemView.findViewById<View>(R.id.card) as CardView
        }
    }
    init {
        this.actions = actions
        this.context = context
        this.fragment = fragment
        inflater = LayoutInflater.from(context)
    }
}