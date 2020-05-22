Table invoices = db_opened.getTable("Invoices");
Table invoices_lignes = db_opened.getTable("InvoicesLignes");
Cursor cursor = CursorBuilder.createCursor(invoices_lignes.getIndex("Code"));

for (Row row : invoices) {
    long start = System.currentTimeMillis( );
    System.out.println(String.format("Invoice : '%s'", start));

    for (Row crow : cursor.newIterable().addMatchPattern("Code", row.get("Code"))) {
        System.out.println(String.format("Loop : '%s'", System.currentTimeMillis( )));
    }

    long end = System.currentTimeMillis( );
    System.out.println(String.format("End loop : '%s'", System.currentTimeMillis( )));
    long diff = end - start;
    System.out.println(String.format("Loop elapsed time : '%s' ms", diff ));
}