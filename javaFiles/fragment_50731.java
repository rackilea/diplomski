Class inner = null;
for (Class c : obj1.getClass().getDeclaredClasses()) {
    if ("myPackage.Class1.Class2".equals(c.getName())) {
        inner = c;
        break;
    }
}
Object obj2 = inner.newInstance();