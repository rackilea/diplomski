while( hasMoreRows() ) {
    ... read the three IDs you need into variables from your file ...

    int bookId = someValueFromTheTextRow;
    int userId = someOtherValueFromTheTextRow;
    int itemId = yetAnotherValueFromTheTextRow;

    // After this, just create a PreparedStatement object, bind your IDs to it, and perform an SQL 
    // insert into the DB table you created above
}