@Override
    protected void onStart()
{
    super.onStart();
    FlurryAgent.onStartSession(this, "YOUR_API_KEY");
}

@Override

protected void onStop()
{
    super.onStop();     
    FlurryAgent.onEndSession(this);
}