public void compile() {
    List<Source> list = new ArrayList<Source>();
    for (Map.Entry<PackageClass, String> entry : source.entrySet()) {
        list.add(new Source(entry.getKey().getCanonicalName(), JavaFileObject.Kind.SOURCE, entry.getValue()));
        if(getPackage(entry.getKey().getPackage()) == null) {
            definePackage(entry.getKey().getPackage(), null, null, null, null, null, null, null);
        }
    }
    this.compiler.getTask(null, this.manager, null, null, null, list).call();
}