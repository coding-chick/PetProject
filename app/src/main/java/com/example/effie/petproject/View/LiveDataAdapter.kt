package com.example.effie.petproject.View

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.v7.widget.RecyclerView


abstract class LiveDataAdapter<T, VH : RecyclerView.ViewHolder>(liveData: LiveData<List<T>>, context: LifecycleOwner) :
        RecyclerView.Adapter<VH>() {
    var items: List<T>? = null
    var observer: LiveData<List<T>> = liveData

    init {
        observer.observe(context, Observer { result ->
            if (items == null) {
                items = result
                notifyDataSetChanged()
            } else {
                val itemsSize = items!!.size
                items = result
                this.notifyItemRangeInserted(itemsSize, items!!.size)
            }
        })
    }

}