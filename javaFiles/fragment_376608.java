public void someMethod() {
    // ...

    PackageManager pm = context.getPackageManager();
    boolean isInstalled = isPackageInstalled("com.android.removead", pm);

    // ...
}