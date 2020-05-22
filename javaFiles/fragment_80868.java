if (localName.equalsIgnoreCase("Set")
        && attributes.getValue("name").equalsIgnoreCase(
                "BUSINESS")) {
    curElement = 1;
} else if (localName.equalsIgnoreCase("Set")
        && attributes.getValue("name").equalsIgnoreCase(
                "LASTCOLLECTION")) {
    curElement = 2;
}