Document document = Document.parse(jsonString);
List<Document> countsArray = document.get("counts",List.class);
for (Document doc : countsArray){
    doc.keySet(); //keys
    doc.values(); //values
    for (Map.Entry entry : doc.entrySet()){
        // iterate over each pair
    }
}