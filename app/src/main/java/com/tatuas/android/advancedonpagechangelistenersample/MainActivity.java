package com.tatuas.android.advancedonpagechangelistenersample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main_activity_log";

    TabLayout tabLayout;

    Toolbar toolbar;

    ViewPager viewPager;

    MainFragmentPagerAdapter mainFragmentPagerAdapter;

    @NonNull
    private AdvancedOnPageChangeListener listener = new AdvancedOnPageChangeListener() {

        @Override
        public void onFirstPageDisplayed(int position) {
            super.onFirstPageDisplayed(position);
            Toast.makeText(MainActivity.this, "d:position:" + position, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "position:" + position + ", " + mainFragmentPagerAdapter.getFragmentTag(position));
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            Toast.makeText(MainActivity.this, "s:position:" + position, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "position:" + position + ", " + mainFragmentPagerAdapter.getFragmentTag(position));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        setSupportActionBar(toolbar);

        mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainFragmentPagerAdapter);

        // 予めポジションを指定する場合は、listenerをaddする前に行うこと
        viewPager.setCurrentItem(new Random().nextInt());

        viewPager.addOnPageChangeListener(listener);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        viewPager.removeOnPageChangeListener(listener);
        super.onDestroy();
    }

    private class MainFragmentPagerAdapter extends AdvancedFragmentPagerAdapter {

        MainFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Page1Fragment();
                case 1:
                    return new Page2Fragment();
                case 2:
                    return new Page3Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public String getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Page 1";
                case 1:
                    return "Page 2";
                case 2:
                    return "Page 3";
            }

            return null;
        }

    }
}
