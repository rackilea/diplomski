String dbFileSpec = "C:/Users/Gord/Desktop/InvoiceTest.mdb";
try (Connection conn=DriverManager.getConnection("jdbc:ucanaccess://" + dbFileSpec)) {
    PreparedStatement psLignes = conn.prepareStatement("SELECT * FROM InvoicesLignes WHERE Code=?");
    Statement sInv = conn.createStatement();
    ResultSet rsInv = sInv.executeQuery("SELECT Code FROM Invoices");
    while (rsInv.next()) {
        long start = System.currentTimeMillis( );
        System.out.println(String.format("Invoice : '%s'", start));

        psLignes.setString(1, rsInv.getString("Code"));
        ResultSet rsLignes = psLignes.executeQuery();
        while (rsLignes.next()) {
            System.out.println(String.format("Loop : '%s'", System.currentTimeMillis()));
        }
        long end = System.currentTimeMillis( );
        System.out.println(String.format("End loop : '%s'", System.currentTimeMillis( )));
        long diff = end - start;
        System.out.println(String.format("Loop elapsed time : '%s' ms", diff ));
    }
    conn.close();
} catch (Exception e) {
    e.printStackTrace(System.out);
}