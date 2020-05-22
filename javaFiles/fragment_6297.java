for(PackageInfo p : packs){
    if(!isSystemPackage(p)){
        if(usesInternet(p)){
            String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
            Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
            List.add(new AppList(appName, icon));
        }
    }
}