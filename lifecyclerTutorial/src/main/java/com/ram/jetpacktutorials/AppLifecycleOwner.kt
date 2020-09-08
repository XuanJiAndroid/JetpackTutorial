package com.ram.jetpacktutorials

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class AppLifecycleOwner : LifecycleOwner, MyApplication.ActivityCallback.ForegroundChangeListener {
    val lifecycleRegistry by lazy { LifecycleRegistry(this) }
    private lateinit var application: Application
    override fun getLifecycle(): Lifecycle = lifecycleRegistry
    var listener: ForegroundChangeListener? = null
    fun init(application: MyApplication) {
        application.activityLifecycleCallback.listener = this
        this.application = application
    }

    override fun hasForegroundChange(isInForeground: Boolean) {
        listener?.apply { hasForegroundChange(isInForeground) }
    }


    /**
     * 前后台切换回调
     */
    interface ForegroundChangeListener {
        fun hasForegroundChange(isInForeground: Boolean)
    }

}