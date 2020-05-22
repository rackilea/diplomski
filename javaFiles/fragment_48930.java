try {
    Connection = connectionFactory.getConnection();

    ps = statement.prepareStamement(someQuery);
    // execute and read and stuff

    // now you want to use the ps again, since you don't want ps1, ps2, ps3, etc.
    // v v v v v v v v v v v
    SomeUtilClass.close(ps);
    // ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^
    ps = statement.prepareStatement(someOtherQuery); // DOES THIS FORM A POTENTIAL LEAK?
} catch (a lot of exceptions) {
    // process exceptions
} finally {

    // close the resources (using util class with null-checks and everything)
    SomeUtilClass.close(ps);
    SomeUtilClass.close(connection);
}