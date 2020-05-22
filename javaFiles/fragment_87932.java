Set<String> classNames = new HashSet<String>();
for(String key : cmatrix.keySet()) {
    String[] classes = key.split(",");
    if(classes != null && classes.length > 0) {
        classNames.addAll(Arrays.asList(classes));
    }
}