public static String getInsertedCustomerOrder(String[][] input) {
    boolean first = true;
    String query = "";
    for (String[] product : input) {
        if (first)
            first = false;
        else
            query += " + ";
        query += "(SELECT PRICE FROM PRODUCT WHERE NAME = '" + product[0] + "') * "
               + product[1];
    }
    query = "(" + query + ")";
    return query;
}