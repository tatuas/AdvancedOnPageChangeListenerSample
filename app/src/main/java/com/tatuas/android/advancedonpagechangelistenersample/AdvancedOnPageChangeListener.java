package com.tatuas.android.advancedonpagechangelistenersample;

import android.support.annotation.CallSuper;
import android.support.v4.view.ViewPager;

public abstract class AdvancedOnPageChangeListener extends ViewPager.SimpleOnPageChangeListener {

    private boolean isFirst = true;

    @CallSuper
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (isFirst && positionOffset == 0 && positionOffsetPixels == 0) {
            onFirstPageDisplayed(position);
            isFirst = false;
        }
    }

    @SuppressWarnings("unused")
    public void onFirstPageDisplayed(int position) {
        // This space for rent
    }
}
