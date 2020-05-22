You have to override onNewIntent and get the extra there.  

@Override
protected void onNewIntent(Intent intent)
{
    super.onNewIntent(intent);


    int number = intent.getIntExtra("number", -1);
}