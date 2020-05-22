public void StartTrack()
{
    mContinueThread=true;

    if (!mThreadIsStarted)
    {
        mThreadIsStarted=true;
        t = new Thread(r);
        t.start();
    }
}