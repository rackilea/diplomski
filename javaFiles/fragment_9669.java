package com.loader;

import dalvik.system.DexClassLoader;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LoaderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DexClassLoader dLoader = new DexClassLoader("/sdcard/DroidBoxTests.apk","/sdcard/", null, ClassLoader.getSystemClassLoader().getParent());

        Class calledClass = null;
        try {
            calledClass = dLoader.loadClass("droidbox.tests.DroidBoxTests");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Intent it=new Intent(this, calledClass);
        it.setClassName("droidbox.tests", "droidbox.tests.DroidBoxTests");
        startActivity(it);
    }
}