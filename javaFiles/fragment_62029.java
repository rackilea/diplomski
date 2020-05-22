public MyGLSurfaceView(Context context) {
    super(context);
    setRenderer(new MyGLRenderer());
    setEGLContextClientVersion(2);
    setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
}