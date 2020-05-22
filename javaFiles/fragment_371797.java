try {
    // The newInstance() call is a work around for some
    // broken Java implementations

    Class.forName("com.mysql.jdbc.Driver").newInstance();
} catch (Exception ex) {
    // handle the error
}