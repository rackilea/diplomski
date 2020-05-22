// user input, hardcoded for the example
String fieldName = "cfg22";

MyClass blank = new MyClass();
Object value = null;
try {
    value = MyClass.class.getDeclaredField(fieldName).get(blank);
} catch (IllegalArgumentException e) {
    // if the specified object is not an instance of the class or
    // interface declaring the underlying field (or a subclass or
    // implementor thereof)
    e.printStackTrace();
} catch (SecurityException e) {
    // if a security manager, s, is present [and restricts the access to
    // the field]
    e.printStackTrace();
} catch (IllegalAccessException e) {
    // if the underlying field is inaccessible
    e.printStackTrace();
} catch (NoSuchFieldException e) {
    // if a field with the specified name is not found
    e.printStackTrace();
}

System.out.println(value);