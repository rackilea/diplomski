public void stopRecording() {
    if (null != recorder) {
        recorder.stop();
        recorder.reset();
        recorder.release();

        recorder = null;
    }
}