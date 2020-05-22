package org.me.myandroidstuff;

import java.util.ArrayList;
import java.util.Collections;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class JumbleTextApplicationActivity extends Activity{

    public View TextView;
    public View EditText;
    public View Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumble_text_application);

        EditText editbox = (EditText)findViewById(R.id.Editbox1); 
        TextView jumbledword = (TextView) findViewById(R.id.jumble);
        Button btnJumble = (Button)findViewById( R.id.button );
        TextView tbox1 =(TextView)findViewById(R.id.textBox1);
        tbox1.setTypeface(Typeface.SANS_SERIF);
        tbox1.setTypeface(Typeface.MONOSPACE);

        btnJumble.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                jumbleMe(editbox.getText().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jumble_text_application, menu);
        return true;
    }

    private void jumbleMe(String word) {
        ArrayList<Character> jumblew = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
        jumblew.add(word.charAt(i));
    }
        Collections.shuffle(jumblew);
        String result = "";
        for (Character character : jumblew) {
            result += character;
        }
        jumbledword.setText(result);
    }
}