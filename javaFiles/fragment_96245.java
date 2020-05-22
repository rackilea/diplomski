Table invoices = db_opened.getTable("Invoices");
Table invoices_lignes = db_opened.getTable("InvoicesLignes");

for (Row row : invoices) {
    long start = System.currentTimeMillis( );
    System.out.println(String.format("Invoice : '%s'", start));

    IndexCursor cursor = new CursorBuilder(invoices_lignes)
            .setIndexByName("Code")
            .setSpecificEntry(row.get("Code"))
            .toIndexCursor();
    for (Row crow : cursor) {
        System.out.println(String.format("Loop : '%s'", System.currentTimeMillis( )));
    }

    long end = System.currentTimeMillis( );
    System.out.println(String.format("End loop : '%s'", System.currentTimeMillis( )));
    long diff = end - start;
    System.out.println(String.format("Loop elapsed time : '%s' ms", diff ));
}