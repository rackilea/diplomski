ChoiceDialog dialog = new ChoiceDialog(Printer.getDefaultPrinter(), Printer.getAllPrinters());
dialog.setHeaderText("Choose the printer!");
dialog.setContentText("Choose a printer from available printers");
dialog.setTitle("Printer Choice");
Optional<Printer> opt = dialog.showAndWait();
if (opt.isPresent()) {
    Printer printer = opt.get();
    // start printing ...
}