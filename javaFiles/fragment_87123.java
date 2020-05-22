public Collection<String> getPackages() {
    Set<String> packages = new HashSet<String>();
    for (Package aPackage : Package.getPackages()) {
        packages.add(aPackage.getName());
    }
    return packages;
}