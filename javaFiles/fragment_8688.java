List definedNames = new ArrayList();
definedNames = workbook.getAllNames();
Iterator<List> definedNameIterator = definedNames.iterator();
while (definedNameIterator.hasNext()) {
    Name name = (Name) definedNameIterator.next();
    System.out.println(name.getNameName());
    System.out.println(name.getRefersToFormula());
    System.out.println();
}