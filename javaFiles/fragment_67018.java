Class inputClass = null;
try {
    inputClass = Class.forName("my.package.MyClass");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}