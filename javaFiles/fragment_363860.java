//add the Category
Element Category = doc.createElement("category");
Rows.appendChild(Category);
if(excel.getCategory() != null){
    Category.appendChild(doc.createTextNode(excel.getCategory()));
}