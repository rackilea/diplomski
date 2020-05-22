print.setOnAction(event -> {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF File", "*.pdf"));
        File selectedFile = fileChooser.showSaveDialog(print.getScene().getWindow());
        if (selectedFile != null) {
           String dest = selectedfile.getAbsolutePath();
           PdfWriter writer = new PdfWriter(dest);
           PdfDocument pdf = new PdfDocument(writer);
           Document document = new Document(pdf);
           //DOCUMENT WRITING CODE BEGINS
         }
}