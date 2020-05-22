// User of the document
{
    doc = documentManager.openDocument("doc1", WRITE);
    //...
    doSomethingWithDocument(doc);
    //...
    documentManager.closeDocument(doc);
}

// Implementation of auxiliary function
void doSomethingWithDocument(Document doc) {
     if(!doc.isWritable()) throw new Exception("Read-only document!");
     // Process document
}