// Don't forget to add "Eclipse-BuddyPolicy: global" to MANIFEST.MF
public Collection<String> getPackages() {
    Set<String> packages = new HashSet<String>();
    BundleContext context = Activator.getDefault().getBundle()
            .getBundleContext();
    Bundle[] bundles = context.getBundles();
    PackageAdmin pAdmin = getPackageAdmin(context);

    for (Bundle bundle : bundles) {
        ExportedPackage[] ePackages = pAdmin.getExportedPackages(bundle);
        if (ePackages != null) {
            for (ExportedPackage ePackage : ePackages) {
                packages.add(ePackage.getName());
            }
        }
    }

    return packages;
}

public PackageAdmin getPackageAdmin(BundleContext context) {
    ServiceTracker bundleTracker = null;
    bundleTracker = new ServiceTracker(context,
            PackageAdmin.class.getName(), null);
    bundleTracker.open();
    return (PackageAdmin) bundleTracker.getService();
}