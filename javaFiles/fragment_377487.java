@Override
protected void onResume() {
    super.onResume();
    threadIsStopped = false;
    //start thread here
} 

@Override
protected void onPause() {
    super.onResume();
    threadIsStopped = true;
}