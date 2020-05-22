private Drawable getIconFromPackageName(final String packageName) {
        PackageManager packageManager = getPackageManager();
        try {
            Drawable icon = packageManager.getApplicationIcon(packageName);
            return icon;
        } catch (NameNotFoundException e) {
            Toast toast = Toast.makeText(this, "error in getting icon", Toast.LENGTH_SHORT);
            toast.show();
            e.printStackTrace();
        }
        return null;
}