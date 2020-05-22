package com.javatpoint.seekbar;
import android.os.Bundle;  
import android.app.Activity;  
import android.view.Menu;  
import android.widget.SeekBar;  
import android.widget.SeekBar.OnSeekBarChangeListener;  
import android.widget.Toast;  
public class MainActivity extends Activity implements OnSeekBarChangeListener{  
SeekBar seekBar1, seekBar2, seekBar3;
@Override  
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.activity_main);  

    seekBar1=(SeekBar)findViewById(R.id.seekBar1);  
    seekBar1.setOnSeekBarChangeListener(this);
    seekBar1.setTag("1");
    seekBar2=(SeekBar)findViewById(R.id.seekBar2);
    seekBar2.setOnSeekBarChangeListener(this);
    seekBar2.setTag("2");
    seekBar3=(SeekBar)findViewById(R.id.seekBar3);
    seekBar3.setOnSeekBarChangeListener(this);
    seekBar3.setTag("3");
}  
@Override  
public void onProgressChanged(SeekBar seekBar, int progress,  
        boolean fromUser) {
    changeValue(seekBar.getTag(), progress);
}  
@Override  
public void onStartTrackingTouch(SeekBar seekBar) {  
    Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
}  
@Override  
public void onStopTrackingTouch(SeekBar seekBar) {  
    Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();  
}  
@Override  
public boolean onCreateOptionsMenu(Menu menu) {  
    // Inflate the menu; this adds items to the action bar if it is present.  
    getMenuInflater().inflate(R.menu.main, menu);  
    return true;  
}
public void changeValue(Object a, int progress){
    if(a=="1"){
        Toast.makeText(getApplicationContext(), "seekbar1 progress: "+progress, Toast.LENGTH_SHORT).show();
    }
    if(a=="2"){
        Toast.makeText(getApplicationContext(), "seekbar2 progress: "+progress, Toast.LENGTH_SHORT).show();
    }
    if(a=="3"){
        Toast.makeText(getApplicationContext(), "seekbar3 progress: "+progress, Toast.LENGTH_SHORT).show();
    }
}