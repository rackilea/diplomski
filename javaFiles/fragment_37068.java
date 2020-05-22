package com.commercial.app;

import org.base.api.Activity;

public class CommercialAppActivity extends Activity {
    @Override
    protected void onCreate (Object obj) {
        System.out.println("onCreate implementation overridden by commercial app");
    }

    public static void main(String[] args) {
        System.out.println("Starting commercial app");
        CommercialAppActivity activity = new CommercialAppActivity();
        activity.onCreate(null);
        activity.onCreateOptionsMenu("menu");
        System.out.println("Stopping commercial app");
    }
}