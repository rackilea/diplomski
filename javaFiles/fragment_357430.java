public final Object myMonitor = new Object();

public synchronized byte[] getPicture(int Width, int Height) {
    FrameWidth = Width;
    FrameHeight = Height;

    try {                     
        synchronized(myMonitor) {    
            while (!isPreviewOn) {
                myMonitor.wait();
            }
        }
        isDecoding = true;
        mAvailableFrame = false;

        c.setOneShotPreviewCallback(mPreviewCallback);                

        synchronized(myMonitor) {    
            while (isDecoding) {
                myMonitor.wait();
            }
        }
    }
    catch (Exception e) {   
        return null;
    }

    mAvailableFrame = false;

    return mCurrentFrame;
}

PreviewCallback mPreviewCallback = new PreviewCallback() {

    @Override
    public synchronized void onPreviewFrame(byte[] data, Camera camera) {
        int width = FrameWidth;
        int height = FrameHeight;

        // API 7
        int[] temp = new int[width*height];
        OutputStream out = new ByteArrayOutputStream();
        Bitmap bm = null;

        raw2jpg(temp, data, width, height);
        bm = Bitmap.createBitmap(temp, width, height, Bitmap.Config.RGB_565);
        bm.compress(CompressFormat.JPEG, 100, out);
        /*ref*/mCurrentFrame = ((ByteArrayOutputStream)out).toByteArray();
        mAvailableFrame = true;
        isDecoding = false;
        synchronized(myMonitor) {    
            myMonitor.notify();                   
        }
    }
};