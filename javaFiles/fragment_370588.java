package com.example.masktest.app;

import android.animation.Animator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

import static com.dtx12.android_animations_actions.actions.Actions.*;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAnimation();
            }
        });
    }

    private void playAnimation() {
        final AnimationDrawable firstDrawable = (AnimationDrawable) ContextCompat.getDrawable(MainActivity.this, R.anim.anim_android);
        final AnimationDrawable secondDrawable = (AnimationDrawable) ContextCompat.getDrawable(MainActivity.this, R.anim.anim_android_2);
        final AtomicReference<Integer> cpt = new AtomicReference<>(0);
        Animator sequence = repeat(6, sequence(run(new Runnable() {
            @Override
            public void run() {
                if (imageView.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) imageView.getDrawable()).stop();
                }
                imageView.setImageDrawable(cpt.get() % 2 == 0 ? secondDrawable : firstDrawable);
                ((AnimationDrawable) imageView.getDrawable()).start();
                cpt.set(cpt.get() + 1);
            }
        }), delay(countAnimationDuration(secondDrawable))));
        play(sequence, imageView);
    }

    private float countAnimationDuration(AnimationDrawable drawable) {
        int duration = 0;
        for (int i = 0; i < drawable.getNumberOfFrames(); i++) {
            duration += drawable.getDuration(i);
        }
        return duration / 1000f;
    }
}