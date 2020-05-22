PDDocument document = PDDocument.load(new URL("https://issues.apache.org/jira/secure/attachment/12742551/Testformular1.pdf").openStream());
PDField field = document.getDocumentCatalog().getAcroForm().getField("amt");
System.out.println(field.getClass().getSimpleName());
for (PDAnnotationWidget widget : field.getWidgets())
{
    System.out.println(widget.getRectangle());
}
document.close();