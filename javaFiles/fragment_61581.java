PDFont font = PDType1Font.COURIER;
PDResources resources = new PDResources();
resources.put(COSName.getPDFName("Cour"), font);
PDAcroForm acroForm = new PDAcroForm(document);
document.getDocumentCatalog().setAcroForm(acroForm);
acroForm.setDefaultResources(resources);