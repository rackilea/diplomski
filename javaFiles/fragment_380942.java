int flags = PackageManager.GET_ACTIVITIES
            | PackageManager.GET_CONFIGURATIONS
            | PackageManager.GET_DISABLED_COMPONENTS
            | PackageManager.GET_GIDS | PackageManager.GET_INSTRUMENTATION
            | PackageManager.GET_INTENT_FILTERS
            | PackageManager.GET_PERMISSIONS | PackageManager.GET_PROVIDERS
            | PackageManager.GET_RECEIVERS | PackageManager.GET_SERVICES
            | PackageManager.GET_SIGNATURES;
    PackageManager packageManager = getPackageManager();
    List<PackageInfo> installedPackages = packageManager
            .getInstalledPackages(flags);
    for (PackageInfo packageInfo : installedPackages) {
        ServiceInfo[] services = packageInfo.services;
        PermissionInfo[] permissions = packageInfo.permissions;
    }