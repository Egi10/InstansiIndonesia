package id.co.instansiindonesia.instansiindonesia.splashscreen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import id.co.instansiindonesia.instansiindonesia.R
import id.co.instansiindonesia.instansiindonesia.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler().postDelayed({
            val intent = Intent(baseContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
