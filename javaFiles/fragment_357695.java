@Override
public void onConfigurationChanged(Configuration newConfig)
{
  super.onConfigurationChanged(newConfig);
  setContentView(R.layout.streaming);

  initializeUI(); //contains all the findViewByID etc...
}