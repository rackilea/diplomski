public static Object get() {
    Object longObj = Long.valueOf("0");
    Object casted = (Object) longObj;
    System.out.println("longObj=" + longObj.getClass());
    System.out.println("casted=" + casted.getClass()); // <-- Why the type of "casted" is Long instead of String???
    return casted;
}