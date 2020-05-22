try {
    // execute some SQL
} catch (SQLException ex) {
    if (ex is an expected condition) {
        // deal with it: for example with a "no data found" condition
        // this might mean returning null, or throwing some kind of business exception, such as
        // NoEmployeeFoundException, or whatever
    } else {
        // this is a programming / environment error
        // throw as unchecked exception
        throw new RuntimeException(ex);
    }
}