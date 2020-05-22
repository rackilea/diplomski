@Override
protected void onCreate(final Bundle pSavedInstanceState)
{
    super.onCreate(pSavedInstanceState);

    if (!isOGLES20Compatible())
    {
        view = null;
        showErrorDialogBox();
        return;
    }
    engine = new EngineX(this);

    view = new GLSurfaceViewX(this);

    view.setEGLContextClientVersion(2);


    //
    // Default is usually RGB565 or RGB8 (no Alpha) -- you need RGBA8
    //
    view.setEGLConfigChooser (8, 8, 8, 8, 16, 0);

    //
    // If you want the actual SURFACE to be translucent, then you also need this
    //
    view.setZOrderOnTop         (true);
    view.getHolder ().setFormat (PixelFormat.RGBA_8888);


    view.setRenderer(engine);

    // Render the view only when there is a change in the drawing data
    view.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

    setContentView(view);

}