@Override
public void writeElement(CustomInputField element, PDDocument document, PDPage page, PDAcroForm acroForm) throws IOException {

    String inputFieldKey = element.getKey();
    PDTextField myTextBox = (PDTextField) acroForm.getField(inputFieldKey);
    List<PDAnnotationWidget> widgets;
    if (myTextBox == null) { // if pdtexField don't exist
        myTextBox = new PDTextField(acroForm);
        myTextBox.setMultiline(true);
        myTextBox.setPartialName(inputFieldKey);
        myTextBox.setAlternateFieldName(element.getTooltip());
        acroForm.getFields().add(myTextBox);
        widgets = new ArrayList<>();
    } else {
        widgets = myTextBox.getWidgets();
    }
    PDAnnotationWidget widget = new PDAnnotationWidget();
    PDRectangle rect = new PDRectangle(element.getLeft(), page.getMediaBox().getHeight() - (element.getTop() + element.getHeight()), element.getWidth(),
            element.getHeight());
    widget.setRectangle(rect);
    widget.setPage(page);
    widget.setParent(myTextBox);
    widget.setPrinted(true);
    page.getAnnotations().add(widget);
    widgets.add(widget);
    myTextBox.setWidgets(widgets);

}