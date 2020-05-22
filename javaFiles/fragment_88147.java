// get actual screen size
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

// calculate target scale (ORIG_APP_W is max width of image, ORIG_APP_H is max height of image)
        double globalScale_Width = Math.floor( ( width / ORIG_APP_W ) * 100 );
        double globalScale_Height = Math.floor( ( height / ORIG_APP_H ) * 100 );

 // set the scale based on orientation
        if(deviceOrientation==getResources().getConfiguration().ORIENTATION_PORTRAIT){
            super.appView.setInitialScale( (int)globalScale_Height);
        }else if(deviceOrientation==getResources().getConfiguration().ORIENTATION_LANDSCAPE){
            super.appView.setInitialScale( (int)globalScale_Width);
        }