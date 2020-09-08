package com.ram.jetpacktutorials

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity :AppCompatActivity(), AppLifecycleOwner.ForegroundChangeListener {
    val appLifecycleOwner by lazy { AppLifecycleOwner()  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        jumpNextActivityBtn.setOnClickListener {
            startActivity(Intent(this,SecActivity::class.java))
        }
        appLifecycleOwner.init(application as MyApplication)
        appLifecycleOwner.listener = this
    }

    override fun onResume() {
        super.onResume()
    }

    override fun hasForegroundChange(isInForeground: Boolean) {
      val msg = if(isInForeground)
          "前台"
        else "后台"
        Toast.makeText(this,"当前应用处于$msg",Toast.LENGTH_SHORT).show()
    }
}