package com.example.effie.petproject.View

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.effie.petproject.R
import com.example.effie.petproject.ViewModel.PetViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class SearchPetsAdapter(liveData: LiveData<List<PetViewModel>>, owner: LifecycleOwner) :
        LiveDataAdapter<PetViewModel, SearchPetsAdapter.ViewHolder>(liveData, owner) {

    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
        var imageView : ImageView
        var petNameTextView: TextView
        var petDescptionTextView: TextView
        init {
            imageView = cardView.findViewById(R.id.img_dog)
            petNameTextView = cardView.findViewById(R.id.txt_dog_name)
            petDescptionTextView = cardView.findViewById(R.id.txt_description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val frameLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.search_cell, parent, false) as CardView

        return ViewHolder(frameLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.apply {
            Picasso.get()
                    .load(this.imageUrl())
                    .transform(RoundedCornersTransformation(30, 0))
                    // .placeholder(R.id.)
                    .into(holder.imageView)
            this.petModel.apply {
                holder.petNameTextView.text = name.t
                holder.petDescptionTextView.text = description.t
            }
        }
    }

    override fun getItemCount() = items?.size ?: 0
}