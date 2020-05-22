static {
    try {
        System.loadLibrary("opencv_java");
        System.loadLibrary("Visualizer");
    } catch (UnsatisfiedLinkError e) {
        Log.v("ERROR", "" + e);
    }
}