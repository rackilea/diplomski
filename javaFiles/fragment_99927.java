DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        // Get projection matrix.
        float[] projmtx = new float[16];
        camera.getProjectionMatrix(projmtx, 0, 0.1f, 100.0f);

        // Get camera matrix and draw.
        float[] viewmtx = new float[16];
        camera.getViewMatrix(viewmtx, 0);

        float[] anchorMatrix = new float[16];
        anchor.getPose().toMatrix(anchorMatrix, 0);
        float[] world2screenMatrix =    
  virtualObject.calculateWorld2CameraMatrix(anchorMatrix, viewmtx, projmtx);
        double[] anchor_2d =  world2Screen(width, height, world2screenMatrix);