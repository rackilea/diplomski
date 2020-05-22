PrintService[] printServices =
        PrintServiceLookup.lookupPrintServices(null, null); //get printers

for (PrintService printService : printServices) {
    System.out.println("Found print service: " + printService);

    Set<Attribute> attribSet = new LinkedHashSet<Attribute>();

    Class<? extends Attribute>[] supportedAttributeCategories = (Class<? extends Attribute>[]) printService.getSupportedAttributeCategories();

    for (Class<? extends Attribute> category : supportedAttributeCategories) {
        DocFlavor[] flavors = printService.getSupportedDocFlavors();
        for (DocFlavor flavor : flavors) {
            Object supportedAttributeValues = printService.getSupportedAttributeValues(category, flavor, printService.getAttributes());
            if (supportedAttributeValues instanceof Attribute) {
                Attribute attr = (Attribute) supportedAttributeValues;
                attribSet.add(attr);
            } else if (supportedAttributeValues != null) {
                Attribute[] attrs = (Attribute[]) supportedAttributeValues;
                for (Attribute attr : attrs) {
                    attribSet.add(attr);
                }
            }
        }
    }

    for (Attribute attr : attribSet) {
        System.out.println(attr.getName());

        System.out.println(printService.getDefaultAttributeValue(attr.getCategory()));
    }
}