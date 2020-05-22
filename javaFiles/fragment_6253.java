package com.huiges.stackOverFlow.examples

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class Test extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        LinearLayout linear = new LinearLayout(this); 
        linear.setLayoutParams(
                new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,   
                                              LayoutParams.WRAP_CONTENT,
                                              1)
        );


    }

}