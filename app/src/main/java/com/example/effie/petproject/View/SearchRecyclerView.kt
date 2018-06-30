package com.example.effie.petproject.View

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.effie.petproject.R
import com.example.effie.petproject.model.Pet

class SearchPetsAdapter(liveData: LiveData<List<Pet>>, owner: LifecycleOwner) :
        LiveDataAdapter<Pet, SearchPetsAdapter.ViewHolder>(liveData, owner) {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.search_cell, parent, false) as TextView
        // set the view's size, margins, paddings and layout parameters

        return ViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = items?.get(position)?.name?.t ?: "oops"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = items?.size ?: 0
}