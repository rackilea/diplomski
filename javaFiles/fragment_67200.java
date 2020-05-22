PackageManager packageManager=this.getPackageManager(); 
List<PackageInfo> applist=packageManager.getInstalledPackages(0);
Iterator<PackageInfo> it=applist.iterator();
while(it.hasNext()){
PackageInfo pk=(PackageInfo)it.next();
if(PackageManager.PERMISSION_GRANTED==packageManager.checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, pk.packageName)) //checking if the package is having INTERNET permission
{
results.add(""+pk.applicationInfo.loadLabel(packageManager));
}
}