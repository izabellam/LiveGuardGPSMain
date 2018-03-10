package com.example.keren.liveguardgps.spalsh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.keren.liveguardgps.R;
import com.example.keren.liveguardgps.login.LoginActivity;

/**
 * Created by Keren on 11/01/2018.
 */

public class SplashScreenActivity extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_view);

             new Handler().postDelayed(new Runnable() {


            // * Showing splash screen with a timer. This will be useful when you
             //* want to show case your app logo / company


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                //Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
