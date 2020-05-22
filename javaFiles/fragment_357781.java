try {
    String newString = (String)Class.forName("java.lang.String").newInstance();
}
catch (IllegalAccessException iae) {
    // TODO handle
}
catch (InstantiationException ie) {
    // TODO handle
}
catch (ClassNotFoundException cnfe) {
    // TODO handle
}