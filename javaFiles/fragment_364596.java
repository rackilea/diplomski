private BaseLoaderCallback mLoaderCallBack = new BaseLoaderCallback(this) {
    @Override
    public void onManagerConnected(int status) {
        if(status == LoaderCallbackInterface.SUCCESS){

        }else{
            super.onManagerConnected(status);
        }

    }
};

public void onResume(){
    super.onResume();
    OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_1_0, this, mLoaderCallBack);
}