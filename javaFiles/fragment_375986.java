package com.td.gridview;

import java.io.IOException;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class SwipeActivity extends Activity {

    protected int curruntPosition;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_view);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        final int position = i.getExtras().getInt("id");

        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                // Here you can set the wallpaper
                curruntPosition = arg0;

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }

        });

        // set wallpaper on button click
        Button b1 = (Button) findViewById(R.id.wll);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v2) {
                // // TODO Auto-generated method stub

                //

                //

                WallpaperManager myWallpaperManager = WallpaperManager
                        .getInstance(getApplicationContext());
                try {
                    myWallpaperManager
                            .setResource(MainActivity.ICONS[curruntPosition]);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

    }

    //

    //

    public class ImagePagerAdapter extends PagerAdapter {
        int[] icons = MainActivity.ICONS;

        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = SwipeActivity.this;
            ImageView imageView = new ImageView(context);
            // int padding = context.getResources().getDimensionPixelSize(
            // R.dimen.padding_large);
            // imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageResource(icons[position]);
            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }

}