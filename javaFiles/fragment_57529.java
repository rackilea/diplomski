List<questionObject> questionsList=new ArrayList<>();

if (!documentSnapshots.isEmpty()){
    for (DocumentSnapshot snapshot:queryDocumentSnapshots)
        questionsList.add(snapshot.toObject(questionObject.class));

}