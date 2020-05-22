ApplicationRegistry.ApplicationInfo[] applicationInfos =
   ApplicationRegistry.getApplicationInfoById("<application ID of previous version>");

if (applicationInfos.length > 1) {
   context.setVariable("uninstallDir",  
        applicationInfos[0].getInstallationDirectory().getPath());
}