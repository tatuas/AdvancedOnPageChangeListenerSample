package com.tatuas.android.advancedonpagechangelistenersample;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

public abstract class AdvancedFragmentPagerAdapter extends FragmentPagerAdapter {

    @NonNull
    private final SparseArrayCompat<String> fragmentTags;

    public AdvancedFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentTags = new SparseArrayCompat<>();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final Object object = super.instantiateItem(container, position);
        if (object != null && object instanceof Fragment) {
            final String tag = ((Fragment) object).getTag();
            fragmentTags.put(position, tag);
        }
        return object;
    }

    @Nullable
    @SuppressWarnings("unused")
    public String getFragmentTag(int position) {
        return fragmentTags.get(position);
    }
}
