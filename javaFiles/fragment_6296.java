private boolean usesInternet(PackageInfo pInfo) {
    if(pInfo.requestedPermissions != null) {
        for(String i : pInfo.requestedPermissions)
            if(i.equals(Manifest.permission.INTERNET)
                return true;
    }
    return false;
}