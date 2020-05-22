Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable(){
    public void run(){
        mTextView5.setText("Cpu TimeStamp " + mCpuTimeStamp + " time");
    }
});