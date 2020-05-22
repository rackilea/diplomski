for (Object element : button.getKeys()) {
    PdfName key = (PdfName)element;
    if (key.equals(PdfName.T) || key.equals(PdfName.RECT))
        continue;
    if (key.equals(PdfName.FF))
        values.put(key, button.get(key));
    else
        widgets.put(key, button.get(key));
    merged.put(key, button.get(key));
    markUsed(values);
    markUsed(widgets);
}