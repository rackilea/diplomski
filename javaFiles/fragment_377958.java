@SuppressLint("NewApi")
public void surfaceCreated( SurfaceHolder holder ) {
    // Once the surface is created, simply open a handle to the camera hardware.
    camera = openFrontFacingCamera();
    camera.setDisplayOrientation(90);
}


@SuppressLint("NewApi")
private Camera openFrontFacingCamera() 
{
    int cameraCount = 0;
    Camera cam = null;
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    cameraCount = Camera.getNumberOfCameras();
    for ( int camIdx = 0; camIdx < cameraCount; camIdx++ ) {
        Camera.getCameraInfo( camIdx, cameraInfo );
        if ( cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT  ) {
            try {
                cam = Camera.open( camIdx );
            } catch (RuntimeException e) {
                System.out.println("Falied to open.");
            }
        }
    }

    return cam;
}