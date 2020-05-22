private Context mContext;

@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mContext=getApplicationContext();//Get the context here
    }

    //Use this method to show toast
    void showToast(){
        if(mContext != null){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() 
            {
                    Toast.makeText(mContext, "Display your message here", Toast.LENGTH_SHORT)show();
            }
        });

    }
}