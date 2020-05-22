public List<String> getFQNs(String simpleName) {
    if (this.packages == null) {
        this.packages = getPackages();
    }

    List<String> fqns = new ArrayList<String>();
    for (String aPackage : packages) {
        try {
            String fqn = aPackage + "." + simpleName;
            Class.forName(fqn);
            fqns.add(fqn);
        } catch (Exception e) {
            // Ignore
        }
    }
    return fqns;
}