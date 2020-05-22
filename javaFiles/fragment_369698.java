public List<String> getClasses(Context context, String package) {
    List<String> classes = new LinkedList<String>();
    try {
        DexFile dexFile = new DexFile(context.getPackageCodePath());
            for (Enumeration<String> iter = dexFile.entries(); iter.hasMoreElements();) {
                String currentClass = iter.nextElement();
                    if (currentClass.contains(package)) {
                            classes.add(currentClass);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return classes;
}