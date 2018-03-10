//package com.example.keren.liveguardgps;
//
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.FrameLayout;
//
///**
// * Created by amirlubashevsky on 09/03/2018.
// */
//
//public class BaseActivity extends AppCompatActivity {
//
//    @Override
//    public void setContentView(int layoutResID) {
//        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
//        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
//        getLayoutInflater().inflate(layoutResID, activityContainer, true);
//        super.setContentView(fullView);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        setTitle("GPS Guard");
//
//        if (useToolbar())
//        {
//            setSupportActionBar(toolbar);
//            setTitle("Activity Title");
//        }
//        else
//        {
//            toolbar.setVisibility(View.GONE);
//        }
//
//    }
//
//    protected boolean useToolbar()
//    {
//        return true;
//    }
//}
