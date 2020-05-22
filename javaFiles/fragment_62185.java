//Adds a DOCUMENT structure element as the structure tree root.
void addRoot() {
    PDStructureElement root = new PDStructureElement(StandardStructureTypes.DOCUMENT, null);
    root.setAlternateDescription("The document's root structure element.");
    root.setTitle("PDF Document");
    pdf.getDocumentCatalog().getStructureTreeRoot().appendKid(root);
    currentElem = root;
    rootElem = root;
}