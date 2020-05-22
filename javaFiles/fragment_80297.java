try {
       requestWindowFeature(Window.FEATURE_NO_TITLE);
    } catch (Exception ex) {
        log("AndroidApplication", "Content already displayed, cannot request FEATURE_NO_TITLE", ex);
    }
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
setContentView(graphics.getView(), createLayoutParams());