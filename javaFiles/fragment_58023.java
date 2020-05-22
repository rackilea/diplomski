@Override
public void onStart() {
    super.onStart();
    if (mReadThread != null) {
        mReadThread.start();
    } else {
        init();
    }
}