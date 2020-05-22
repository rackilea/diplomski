public void CaptureMapScreen() 
{
SnapshotReadyCallback callback = new SnapshotReadyCallback() {
            Bitmap bitmap;

            @Override
            public void onSnapshotReady(Bitmap snapshot) {
                // TODO Auto-generated method stub
                bitmap = snapshot;
                try {
                    FileOutputStream out = new FileOutputStream("/mnt/sdcard/"
                        + "MyMapScreen" + System.currentTimeMillis()
                        + ".png");

                    // above "/mnt ..... png" => is a storage path (where image will be stored) + name of image you can customize as per your Requirement

                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        myMap.snapshot(callback);

        // myMap is object of GoogleMap +> GoogleMap myMap;
        // which is initialized in onCreate() => 
        // myMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_pass_home_call)).getMap();
}