package com.longclick;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView t1=(TextView)findViewById(R.id.text);
       t1.isClickable();

      t1.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
           // TODO Auto-generated method stub
           Toast.makeText(getApplicationContext(), "Long Clicked", Toast.LENGTH_SHORT).show();
           return true;
        }
     });

}

//@Override
//public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.activity_main, menu);
    //return true;
//}

@Override
public boolean onTouchEvent(MotionEvent event)
{
    Context context=getApplication();
    CharSequence text = "This is for ontouch event";
    int duration = Toast.LENGTH_SHORT;
     Toast Msg = Toast.makeText(context,text,duration);
     int x=(int)event.getX();
     int y=(int)event.getY();
     Msg.setGravity(Gravity.TOP|Gravity.LEFT, x, y);
     Msg.show();

    return true;
} //Error type Syntax error on token "}", delete this token    


}