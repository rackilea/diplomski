public void LogOut()
{
    mContinueThread=false;
    if (mThreadIsStarted)
    {
        //THREAD STOP
        mContinueThread=false;
        mThreadIsStarted=false;

        //THREAD TO NULL
        t=null;
    }

    ...
}