try {
    //do the insert
} catch (SQLException e) {
    if(e.getMessage().contains("MY_CONSTRAINT_NAME")) {
        //duplicate key
    } else {
        //some other error
    }
}