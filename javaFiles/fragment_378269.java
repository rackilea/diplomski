import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;

public class Main2Activity extends AppCompatActivity{


  SurfaceView surfaceView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
    //Method for making the activity full screen
    //With SurfaceView
    makeItFullScreen();
  }

  private void makeItFullScreen(){
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    getSupportActionBar().hide();
    //Changing SurfaceView background color
    surfaceView.setBackgroundColor(Color.RED);

    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

    ViewGroup.LayoutParams videoLayoutParams = surfaceView.getLayoutParams();
    videoLayoutParams.width = displayMetrics.widthPixels;
    videoLayoutParams.height = displayMetrics.heightPixels;

    ViewGroup.LayoutParams videoParams = surfaceView.getLayoutParams();
    videoParams.width = displayMetrics.widthPixels;
    videoParams.height = displayMetrics.heightPixels;
  }

}