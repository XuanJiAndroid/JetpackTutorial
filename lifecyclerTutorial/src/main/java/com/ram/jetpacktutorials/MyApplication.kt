package com.ram.jetpacktutorials

import android.app.Activity
import android.app.Application
import android.os.Bundle

class MyApplication : Application() {
    val activityLifecycleCallback by lazy { ActivityCallback() }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(activityLifecycleCallback)
    }


    class ActivityCallback : ActivityLifecycleCallbacks {
        private var currentForegroundActivityCount = 0
        var listener: ForegroundChangeListener? = null
        override fun onActivityStarted(p0: Activity) {
            currentForegroundActivityCount++
            calculatHasForeground()
        }

        override fun onActivityStopped(p0: Activity) {
            currentForegroundActivityCount--
            calculatHasForeground()
        }

        private fun calculatHasForeground(){
            listener?.apply {
                hasForegroundChange(currentForegroundActivityCount!=0)
            }
        }

        /**
         * 前后台切换回调
         */
        interface ForegroundChangeListener {
            fun hasForegroundChange(isInForeground: Boolean)
        }

        override fun onActivityCreated(p0: Activity, p1: Bundle?) {

        }

        override fun onActivityResumed(p0: Activity) {

        }

        override fun onActivityPaused(p0: Activity) {

        }

        override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {

        }


        override fun onActivityDestroyed(p0: Activity) {

        }
    }


}