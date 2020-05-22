@Override
public void onConfigurationChanged(Configuration newConfig)
{
    super.onConfigurationChanged(newConfig);
    if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
    {
        setContentView(R.layout.activity_main_h);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }
    else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
    {
        setContentView(R.layout.activity_main_v);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }
}