PackageManager packageManager = this.cordova.getActivity().getPackageManager();
String installer = packageManager.getInstallerPackageName( "com.myapp" );

if ( installer == null ) {
    // not installed via application (like Google Play)
} else {
    // installed via application
}