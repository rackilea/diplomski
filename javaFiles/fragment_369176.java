@Override
protected void onProgressUpdate(Integer... progress) {
    super.onProgressUpdate(progress);

    this.mProgressDialog2.setProgress(progress[0] * 100/progress[1]);
}