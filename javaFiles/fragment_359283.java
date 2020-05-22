try (ResultSet rs = statement.executeQuery(query)) {
    /* retrieve the data */
} catch (SQLException e) {
    /* handle the exception properly */
    storeExceptionSomewhereElse(e);
}

//...

public void storeExceptionSomewhereElse(SQLException e) {
    /*
        Here you can store the exception in database
        or external data source.
    */
}