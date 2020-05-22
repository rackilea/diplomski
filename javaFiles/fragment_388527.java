Bundle getBundle(BundleContext bundleContext, String symbolicName) {
    Bundle result = null;
    for (Bundle candidate : bundleContext.getBundles()) {
        if (candidate.getSymbolicName().equals(symbolicName)) {
            if (result == null || result.getVersion().compareTo(candidate.getVersion()) < 0) {
                result = candidate;
            }
        }
    }
    return result;
}