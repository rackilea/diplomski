for (int i = 0; i < pkgList.length; i++) {
    Object pkgInfoObj = pkgList.get(i);
    if (pkgInfoObj instanceof PackageInfo) {
        PackageInfo pkgInfo = (PackageInfo) pkgInfoObj;
        ApplicationInfo appInfo = pkgInfo.applicationInfo;
        // do some stuff, doesn't modify pkgInfo or appInfo or pkgList
    }
}