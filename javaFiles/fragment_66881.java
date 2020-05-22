try {
    // ...

    Class.forName("com.google.cloud.sql.jdbc.Driver");

    // ...
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}