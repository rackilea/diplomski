private static final int REQUEST_CODE_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_CODE_CAMERA = 2;
private static int RESULT_LOAD_IMG = 1;
@TargetApi(23)
    public void checkCameraPermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }
        if (this.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
        }
    }

    @TargetApi(23)
    public void checkStoragePermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        if (this.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager
                .PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_EXTERNAL_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Thanks for your permission", LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "We need your permission to save image",
                            LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_CAMERA:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Thanks for your permission", LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "We need your permission to start SOS",
                            LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
}