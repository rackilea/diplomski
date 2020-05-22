private int defaultBrightness = 12;

public CameraSourcePreview(Context context, AttributeSet attrs) {
    super(context, attrs);
    mContext = context;
    mStartRequested = false;
    mSurfaceAvailable = false;

    mSurfaceView = new SurfaceView(context);
    mSurfaceView.getHolder().addCallback(new SurfaceCallback());
    addView(mSurfaceView);
    mSurfaceView.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            cameraFocus(mCameraSource, brightness);
        }
    });
}

private static boolean cameraFocus(@NonNull CameraSource cameraSource, int brightness) {
    Field[] declaredFields = CameraSource.class.getDeclaredFields();

    for (Field field : declaredFields) {
        if (field.getType() == Camera.class) {
            field.setAccessible(true);
            try {
                Camera camera = (Camera) field.get(cameraSource);
                if (camera != null) {
                    Camera.Parameters params = camera.getParameters();
                        params.setExposureCompensation(brightness);
                    camera.setParameters(params);
                    return true;
                }

                return false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            break;
        }
    }

    return false;
}