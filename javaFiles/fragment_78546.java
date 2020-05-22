while (result.next()) {
    Printer printer = new Printer();
    printer.setPrinterid(result.getString("printerid"));
    printer.setNaam(result.getString("printernaam"));
    printer.setAantalKl(result.getInt("aantalkleur"));
    printer.setAantalZw(result.getInt("aantalzwart"));
    printers.add(printer); // Adds the printer to the arraylist.
}