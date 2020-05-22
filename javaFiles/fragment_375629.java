try
{
    long firstInstall = context.getPackageManager().getPackageInfo("package.name", 0).firstInstallTime;
}
catch (PackageManager.NameNotFoundException e)
{
    e.printStackTrace();
}