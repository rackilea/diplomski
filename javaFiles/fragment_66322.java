@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 101) {
  f (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
mMap.setMyLocationEnabled(true);  }
  }                 
}