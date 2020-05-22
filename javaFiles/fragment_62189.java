//Adds the parent tree to root struct element to identify tagged content
void addParentTree() {
    COSDictionary dict = new COSDictionary();
    nums.add(numDictionaries);
    for (int i = 1; i < currentStructParent; i++) {
        nums.add(COSInteger.get(i));
        nums.add(annotDicts.get(i - 1));
    }
    dict.setItem(COSName.NUMS, nums);
    PDNumberTreeNode numberTreeNode = new PDNumberTreeNode(dict, dict.getClass());
    pdf.getDocumentCatalog().getStructureTreeRoot().setParentTreeNextKey(currentStructParent);
    pdf.getDocumentCatalog().getStructureTreeRoot().setParentTree(numberTreeNode);
}