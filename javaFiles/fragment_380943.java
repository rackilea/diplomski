StringBuffer buffer = new StringBuffer();
    try {
        PackageInfo packageInfo = packageManager.getPackageInfo(
                "packageName", flags);
        ServiceInfo[] services = packageInfo.services;
        for (ServiceInfo serviceInfo : services) {
            buffer.append(serviceInfo.name + "\n");
        }
        PermissionInfo[] permissions = packageInfo.permissions;
    } catch (NameNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    textView.setText(buffer);