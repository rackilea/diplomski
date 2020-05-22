public MyGLSurfaceView(Context context) {
    super(context);
    setEGLContextClientVersion(2);
    setRenderer(new MyGLRenderer());
    setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
}