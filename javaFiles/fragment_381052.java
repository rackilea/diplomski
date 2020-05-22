public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener, NavigationView.OnNavigationItemSelectedListener{
   // other code and methods of NavigationView.OnNavigationItemSelectedListener

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }

}