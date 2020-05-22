@Override
public void onStart() {
    super.onStart();
    if (mReadThread != null) {
        mReadThread.start();
    }
}

@Override
public void onStop() {
    super.onStop();
    if (mReadThread != null) {
        mReadThread.interrupt();
    }
}