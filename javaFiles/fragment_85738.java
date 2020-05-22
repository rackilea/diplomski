package com.example.anotherviewaddtest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout=(LinearLayout) findViewById(R.id.Linear);
        for(int i=0;i<50;i++){ //create a scrollview
            TextView tv=new TextView(this);
            tv.setTextColor(Color.BLUE);
            tv.setText("t\ne\nx\nt\nV\nie\nw "+Integer.toString(i));
            tv.setBackgroundColor(Color.GREEN+10000*i);
            tv.setOnClickListener((new OnClickListener() {
                public void onClick(View v){                    
                    func(v);
                }
               }));
            layout.addView(tv);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void func(View toAdd){

// values for animation x_start
            int toAdd_top=toAdd.getTop();

        ViewGroup root=(ViewGroup) toAdd.getRootView();

//remove view from scrollview       
        ViewGroup parent=(ViewGroup)toAdd.getParent();
        ScrollView itsParent=(ScrollView)parent.getParent();
        parent.removeView(toAdd);
     // animation values x_start, x_end and y_end

int scrolledAmount=itsParent.getScrollY();      
            int margin=itsParent.getTop();
            int scrollView_left=itsParent.getLeft();
            int scrollView_top=itsParent.getTop();
            if(scrolledAmount==0) // fix for first element selected
                scrolledAmount=-scrollView_top;


//gets the main layout of the app and adds the removed to it. Traverse down along your own decor view if it is different . In this example i have decorView->LinearLayout(child at 0)->FrameLayout (child at 1)->main layout of app(child at 0) 
        ViewGroup base=(ViewGroup) ((FrameLayout)((LinearLayout)root.getChildAt(0)).getChildAt(1)).getChildAt(0);
        base.addView(toAdd);


//  set the animation   
        TranslateAnimation ani= new TranslateAnimation(scrollView_left,scrollView_left,-scrolledAmount,-(toAdd_top-margin));
        ani.setDuration(1000);
        toAdd.startAnimation(ani);
//listener to call new activity at end of animation
        ani.setAnimationListener(new AnimationListener(){
            @Override
            public void onAnimationEnd(Animation anim){
                //start new Activity here
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {}
            @Override
            public void onAnimationStart(Animation arg0) {}
            ;});
// removes the view that was added to main layout
        base.removeView(toAdd);
    }
    }