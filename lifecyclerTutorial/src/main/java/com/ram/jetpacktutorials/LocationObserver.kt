@file:Suppress("INVISIBLE_ABSTRACT_MEMBER_FROM_SUPER_WARNING")

package com.ram.jetpacktutorials

import android.util.Log
import androidx.lifecycle.*

private val TAG = LocationObserver::class.simpleName
class LocationObserver : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        val name = when(event){
            Lifecycle.Event.ON_START-> "onStart"
            Lifecycle.Event.ON_CREATE -> "onCreate"
            Lifecycle.Event.ON_RESUME -> "onResume"
            Lifecycle.Event.ON_PAUSE -> "onPause"
            Lifecycle.Event.ON_STOP -> "onStop"
            Lifecycle.Event.ON_DESTROY -> "onDestroy"
            Lifecycle.Event.ON_ANY -> "onAny"
        }
        Log.d(TAG,"当前执行了$name 函数，宿主是：${source.javaClass.simpleName}")
    }

    /* @OnLifecycleEvent(Lifecycle.Event.ON_START)
     fun onStart(owner: LifecycleOwner){
         //宿主执行了onStart函数
         Log.d(TAG,"当前执行了onStart函数，宿主是：${owner.javaClass.simpleName}")
     }
     @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
     fun onStop(owner: LifecycleOwner){
         //宿主执行了onStop函数
         Log.d(TAG,"当前执行了onStop函数，宿主是：${owner.javaClass.simpleName}")
     }*/


}