int determineSafe(PDDocument document, PDAnnotationWidget widget) throws IOException
{
    COSDictionary widgetObject = widget.getCOSObject();
    PDPageTree pages = document.getPages();
    for (int i = 0; i < pages.getCount(); i++)
    {
        for (PDAnnotation annotation : pages.get(i).getAnnotations())
        {
            COSDictionary annotationObject = annotation.getCOSObject();
            if (annotationObject.equals(widgetObject))
                return i;
        }
    }
    return -1;
}