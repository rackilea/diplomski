@Test
public void ViewUserData(){

    FindIterable iterable = mock(FindIterable.class);
    MongoCursor cursor = mock(MongoCursor.class);
    Document doc1=new Document("1","bharathi");
    Document doc2=new Document("2","madhavi");
    when(iterable.iterator()).thenReturn(cursor);
    when(cursor.hasNext()) 
      .thenReturn(true)
      .thenReturn(true)
     .thenReturn(false); 
    when(cursor.next())
      .thenReturn(doc1)
      .thenReturn(doc2); 
    Mockito.when(collection.find(Mockito.any(BasicDBObject.class))).thenReturn(iterable);
    mdmdaoimpl.viewUserData("1","bharathi");
    verify(collection,times(1)).find(Mockito.any(BasicDBObject.class));
}