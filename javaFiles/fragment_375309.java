Context context = new Context();
    PackageManager m = getPackageManager();
    String s = getPackageName();
    PackageInfo p = m.getPackageInfo(s, 0);
    s = p.applicationInfo.dataDir;
    s +=  "/app/config/xmlsignature-config.xml";
    context.setConfig(new Config(s));