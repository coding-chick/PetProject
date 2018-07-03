package com.example.effie.petproject.View

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.support.v4.graphics.drawable.RoundedBitmapDrawable
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.effie.petproject.R
import com.example.effie.petproject.model.Pet
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class SearchPetsAdapter(liveData: LiveData<List<Pet>>, owner: LifecycleOwner) :
        LiveDataAdapter<Pet, SearchPetsAdapter.ViewHolder>(liveData, owner) {

    class ViewHolder(val frameLayout: FrameLayout) : RecyclerView.ViewHolder(frameLayout) {
        var imageView : ImageView
        var textView :TextView
        init {
            imageView = frameLayout.findViewById(R.id.img_dog)
            textView = frameLayout.findViewById(R.id.txt_dog_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val frameLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.search_cell, parent, false) as FrameLayout

        return ViewHolder(frameLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dog = items?.get(position)
        Picasso.get()
                .load(dog?.media?.photos?.photoList?.get(3)?.t)
                .transform(RoundedCornersTransformation(20, 0))
               // .placeholder(R.id.)
                .into(holder.imageView)
        holder.textView.text = dog?.name?.t
    }

    override fun getItemCount() = items?.size ?: 0
}