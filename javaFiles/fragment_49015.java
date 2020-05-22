public class Test extends Activity implements ViewWasTouchedListener {

...

@Override
public void onCreate(Bundle savedInstanceState) 
{
    ...
    MyExtendedView customView = (MyExtendedView)findViewById(R.id.myCustomeView);
    customView.setWasTouchedListener(this);
    ...
}

public void onViewTouched(float x){
   // do whatever you need to do
}