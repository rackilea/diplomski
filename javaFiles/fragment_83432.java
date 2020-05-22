public final class CreateSimpleForm {
    private static final PDFont FONT = PDType1Font.HELVETICA;
    private PDAcroForm acroForm;
    private String defaultAppearanceString;
    private PDPage page;

    public static void main(String[] args) throws IOException {
        new CreateSimpleForm();
    }

    private CreateSimpleForm() throws IOException {
        PDDocument document = new PDDocument();
        page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDResources resources = new PDResources();
        resources.put(COSName.getPDFName("Helv"), FONT);

        acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);

        acroForm.setDefaultResources(resources);

        defaultAppearanceString = "/Helv 0 Tf 0 g";
        acroForm.setDefaultAppearance(defaultAppearanceString);


        createFormattedField("myField", 125.5);

        document.save("test.pdf");
        document.close();
    }

    private void createFormattedField(String name, Double value) throws IOException {
        String nameHidden = name + "_hidden";
        PDTextField textBox = createField(name, false);
        textBox.setValue(String.format("%1$,.2f", value));
        createField(name + "_hidden", true).setValue(value.toString());
        PDActionJavaScript tfJs = new PDActionJavaScript("this.getField(\"" + nameHidden + "\").value = this.getField(\"" + name + "\").value.replace(/\\./g,'').replace(/\\,/g,'.');");
        PDAnnotationAdditionalActions actions = new PDAnnotationAdditionalActions();
        actions.setPC(tfJs);
        actions.setBl(tfJs);
        textBox.getWidgets().get(0).setActions(actions);
    }

    private PDTextField createField(String name, boolean hidden) throws IOException {
        PDTextField textBox = new PDTextField(acroForm);
        textBox.setPartialName(name);
        textBox.setDefaultAppearance(defaultAppearanceString);

        acroForm.getFields().add(textBox);

        PDAnnotationWidget widget = textBox.getWidgets().get(0);
        PDRectangle rect = new PDRectangle(50, 750, 200, 50);
        widget.setRectangle(rect);
        widget.setPage(page);

        widget.setPrinted(true);
        page.getAnnotations().add(widget);

        widget.setHidden(hidden);
        return textBox;
    }
}