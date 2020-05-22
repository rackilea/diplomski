public static synchronized HelperClass getInstance() {
    if (helperClass == null) {
        helperClass = new HelperClass();
    }
    return helperClass;
}