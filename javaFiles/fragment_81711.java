PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
if (acroForm != null)
{
    for (PDField field : acroForm.getFieldTree())
    {
        System.out.println(field.getFullyQualifiedName());
        for (PDAnnotationWidget widget : field.getWidgets())
        {
            System.out.print(widget.getAnnotationName() != null ? widget.getAnnotationName() : "(NN)");
            System.out.printf(" - fast: %s", determineFast(document, widget));
            System.out.printf(" - safe: %s\n", determineSafe(document, widget));
        }
    }
}