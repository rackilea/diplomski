package com.ai.ultimap;

import com.ai.ultimap.views.HomeView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class UltiMapActivity extends Activity {
private View hv;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    hv = new HomeView(this);
}
}