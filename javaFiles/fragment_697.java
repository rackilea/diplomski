@Override
protected void onNewIntent(Intent intent)
{
    super.onNewIntent(intent);

    if (intent != null) {
        boolean showStuff = intent.getBooleanExtra("showStuff", false);
        if (showStuff) {
             showStuff();
         }
    }  
}