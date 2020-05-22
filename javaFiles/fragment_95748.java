public static void main(String[] args) throws IOException
{
  String formTemplate = "myFormPdf.pdf";

  try (PDDocument pdfDocument = PDDocument.load(new File(formTemplate)))
  {
    PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();
    // you can read ttf from resources as well, this is just for testing 
    PDFont font = PDType0Font.load(pdfDocument,new File("/path/to/font.ttf"));
    String fontName = acroForm.getDefaultResources().add(pdfont).getName();
    if (acroForm != null)
    {
        PDTextField field = (PDTextField) acroForm.getField( "sampleField" );
        field.setDefaultAppearance("/"+fontName +" 0 Tf 0 g");
        field.setValue("جملة");
    }

    pdfDocument.save("updatedPdf.pdf"); 
  }
}