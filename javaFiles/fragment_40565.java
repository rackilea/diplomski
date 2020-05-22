private void CallChildFragmentMethods(ViewPager viewPager, PagerAdapter adapter) {
    MapsFragment mapsFragment = (MapsFragment) adapter.instantiateItem(viewPager, 0);
    mapsFragment.ReloadMapsFragment();
}

@Override
public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch (requestCode) {

        case MY_LOCATION_REQUEST_CODE:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // phone permission is granted, call register and pass empty getMyPhoneNumber
               // Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                CallChildFragmentMethods(viewPager, adapter);
            } else {
                // phone permission is not granted, call register and pass empty phone string
               //  Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                CallChildFragmentMethods(viewPager, adapter);
            }
            break;
    }
}