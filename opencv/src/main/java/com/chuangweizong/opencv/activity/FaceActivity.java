package com.chuangweizong.opencv.activity;

import android.app.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.util.Log;

import android.widget.ImageView;

import com.chuangweizhong.opencv.R;
import com.chuangweizong.opencv.fragment.PhotoPageFragment;
import com.chuangweizong.opencv.lib.detect.TClip;
import com.chuangweizong.opencv.view.indicator.TitlePageIndicator;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.lang.CharSequence;

public class FaceActivity extends FragmentActivity {

    private static final String TAG = "Demo";
    private ViewPager pager;
    private TitlePageIndicator indicator;
    private PhotoPageAdapter adapter;

    private int[] TITLE_IDS = { R.string.photo_face, R.string.photo_noface };
    private int[] PHOTO_IDS = { R.drawable.a1, R.drawable.b1 };

    private String config;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_face_test);

        adapter = new PhotoPageAdapter(getSupportFragmentManager());
        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);
        indicator = (TitlePageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);

        config = TClip.copyConfig(this, TClip.CONFIG, R.raw.haarcascade_frontalface_alt);
        Log.d(TAG, "using config path: " + config);

    }

    class PhotoPageAdapter extends FragmentPagerAdapter{

        public PhotoPageAdapter(FragmentManager fm) {
            super(fm);
        }

        public int getCount() {
            return TITLE_IDS.length;
        }

        public CharSequence getPageTitle(int position) {
            return getString(TITLE_IDS[position]);
        }

        public Fragment getItem(int position) {
            return PhotoPageFragment.newInstance(config, PHOTO_IDS[position]);
        }

    };

}
