private void writeApp(){
    final ModelData data = modelData;
    Log.d(TAG+1,data.getAppName());//works fine
    Thread mThread = new Thread(){
        public void run(){
            Log.d(TAG+2,data.getAppName());//doenst works throws NullPointerException
        }
    };
    mThread.start();
}