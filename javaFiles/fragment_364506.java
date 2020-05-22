Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                         ResultSet.CONCUR_READ_ONLY);
    ResultSet srs = stmt.executeQuery(
        "SELECT COF_NAME, PRICE FROM COFFEES");
    while (srs.next()) {
            String name = srs.getString("COF_NAME");
            float price = srs.getFloat("PRICE");
            System.out.println(name + "     " + price);
    }