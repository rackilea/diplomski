public static Element getElementByNameAttribute(String elementName, String nameAttributeValue, Document doc) {
    if (elementName!= null && !elementName.isEmpty() && nameAttributeValue!= null && !nameAttributeValue.isEmpty()) {

        NodeList subCategoryList = doc.getElementsByTagName(elementName);
        for (int i = 0; i < subCategoryList.getLength(); i++) {
            Element element = (Element) subCategoryList.item(i);

            if (nameAttributeValue.equals(element.getAttribute("name"))) {
                return element;
            }
        }
    }

    return null;
}