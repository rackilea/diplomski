int api = 19;
DexFile dexFile = DexFileFactory.loadDexFile(dexFilePath, api);

List<ClassDef> classes = new ArrayList<ClassDef>();

for (ClassDef classDef: dexFile.getClasses()) {
    if (!classDef.getType().startsWith("Landroid/support/")) {
        classes.add(classDef);
    }
}

dexFile = new ImmutableDexFile(classes);
DexFileFactory.writeDexFile(dexFilePath, dexFile);