if(!OpenCVLoader.initDebug()) {
        Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization.");
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
    } else {
        Log.d(TAG, "OpenCV library found inside package using it.");
        mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
    }