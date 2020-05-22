void initializeEGL() {
    //get access to the EGL object, so that we can
    //initialize EGL
    mEGL = (EGL10) EGLContext.getEGL();

    //initialize display
    mDisplay = mEGL.eglGetDisplay(EGL11.EGL_DEFAULT_DISPLAY);
    if(mDisplay == EGL11.EGL_NO_DISPLAY)
    {
        Log.e("SimpleGLView", "Unable to get access to Native Display");
    }

    int[] version = new int[2];
    boolean success = mEGL.eglInitialize(mDisplay, version);
    if(!success) {
        int error = mEGL.eglGetError();
        switch(error) {
        case EGL11.EGL_NOT_INITIALIZED:
            Log.e("SimpleGLView", "Unable to initialize the EGL sub-system");
            break;
        case EGL11.EGL_BAD_DISPLAY:
            Log.e("SimpleGLView", "Display not valid");
            break;
        }
        return;
        }

    int[] mConfigSpec = {   EGL11.EGL_RED_SIZE, 8,
                                EGL11.EGL_GREEN_SIZE, 8,
                                EGL11.EGL_BLUE_SIZE, 8,
                                EGL11.EGL_DEPTH_SIZE, 16,
                                EGL11.EGL_STENCIL_SIZE, 8,
                                EGL11.EGL_NONE };
    EGLConfig[] configs = new EGLConfig[1];
    int[] num_config = new int[1];

    success = mEGL.eglChooseConfig(mDisplay, mConfigSpec, configs, 1, num_config);
    if(success) {
        Log.i("SimpleGLView", "Successfully acquired a surface configuration");
        return;
    }

    mConfig = configs[0];

    mSurface = mEGL.eglCreateWindowSurface(mDisplay,mConfig, holder, null);
    if(mSurface == EGL11.EGL_NO_SURFACE) {
        Log.e("SimpleGLView", "Unable to create surface");
        int error = mEGL.eglGetError();
        switch(error) {
        case EGL11.EGL_BAD_CONFIG:
            Log.e("SimpleGLView", "Invalid configuration selected");
            break;
        case EGL11.EGL_BAD_NATIVE_WINDOW:
            Log.e("SimpleGLView", "Bad native window used");
            break;
        case EGL11.EGL_BAD_ALLOC:
            Log.e("SimpleGLView", "Not enough resources to create a surface");
            break;
        }
        return;
    }

    mContext = mEGL.eglCreateContext(mDisplay, mConfig, EGL11.EGL_NO_CONTEXT, null);
    if(mContext == null) {
        Log.i("SimpleGLView", "Create Context failed");
        return;
    }

    success = mEGL.eglMakeCurrent(mDisplay, mSurface, mSurface, mContext);
    if(success) {
        Log.i("SimpleGLView", "Made current");
    }
}