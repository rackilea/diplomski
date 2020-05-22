MyClass x = null;+
try {
    x = new MyClass();
    ...
} finally {
    x.close();
}