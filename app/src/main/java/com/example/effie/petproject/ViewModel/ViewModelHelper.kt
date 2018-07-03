package com.example.effie.petproject.ViewModel

import android.arch.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.toLiveData(target: MutableLiveData<T>, onError: ((Throwable) -> Unit)): Disposable {
    return this.subscribe(
            { x -> target.postValue(x) }, onError)

}