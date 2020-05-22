private final Handler mHandler = new Handler()
{
    @Override
    public void handleMessage(Message msg)
    {
        super.handleMessage(msg);
        if (mProgreeDialoge.isShowing())
            mProgreeDialoge.dismiss();
    }
};