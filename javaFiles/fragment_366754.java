private final List<Class> classes = new ArrayList<>();

public List<Class> getClasses() {
    return classes;
}

public void setClasses(List<Class> classes) {
    this.classes.clear();
    this.classes.addAll(classes);
}