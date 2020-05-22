package com.ai.ultimap.views;

import com.ai.ultimap.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.view.View.OnClickListener;

public class HomeView extends View implements OnClickListener{

private RadioButton twodRB;
private RadioButton threedRB;
private TextView locTV;
private EditText editlocET;

public HomeView(Activity hAct) {
super(hAct);
    //THE FOLLOWING LINE INFLATES-- IT (or another function which calls xml inflation) 
    //MUST COME BEFORE ANY JAVA ADDRESSING OF WIDGETS IN
    //THE XML LAYOUT
    //Also note that even though you could invoke findViewById from a class extending 
    //View, in this case you must use hAct.findViewById.  I believe this is due to the
    //fact that the activity referenced by hAct is the object responsible for inflating
    //the xml and thus the widgets need to be instantiated from it.  
hAct.setContentView(R.layout.ultimap);
twodRB = (RadioButton) hAct.findViewById(R.id.twodRBV);
threedRB = (RadioButton) hAct.findViewById(R.id.threedRBV);
locTV = (TextView) hAct.findViewById(R.id.locationTV);
editlocET = (EditText) hAct.findViewById(R.id.locationETV);
    //After instantiation however they can be freely accessed from java in 
    //non-activity classes, which is the point; see the next line...
twodRB.setOnClickListener(this);

}

@Override
public void onClick(View v) {
// TODO Auto-generated method stub
locTV.setText("yo");
}

}