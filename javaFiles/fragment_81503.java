AdListener googleAdListener = new AdListener()
{

    @Override
    public void onAdLoaded()
    {
        super.onAdLoaded();
        try
        {
            (LinearLayout) findViewById(R.id.LinearLayout1).setVisibility(View.VISIBLE);
        }
        catch (Exception e)
        {
            Logger.LogException(e);
        }
    }
};

adView.setAdListener(googleAdListener);