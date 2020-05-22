@Override
public boolean isLegacyLayout() {
    return classesDir!=null;
}

@Override
public void setClassesDir(File classesDir) {
    setClassesDir((Object)classesDir);
}

@Override
public void setClassesDir(Object classesDir) {
    this.classesDir = classesDir;
    this.classesDirs.setFrom(classesDir);
}