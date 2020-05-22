String updateString =
        "update " + dbName + ".COFFEES " +
        "set SALES = ? where COF_NAME = ?";

   PreparedStatement updateSales = con.prepareStatement(updateString);
   updateSales.setInt(1, 500); //set value to first `?`
   updateSales.setString(2, "roasted"); //set value to second `?`