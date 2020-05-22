//add the Category
Element Category = doc.createElement("category");
Rows.appendChild(Category);
if(excel.getCategory() != null){
    Category.appendChild(doc.createTextNode(excel.getCategory()));
} else {
    Category.setAttributeNS(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI,
                            "xsi:nil", "true");
}