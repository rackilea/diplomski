@After
public void cleanIndex() {
    index.clear(); //Assuming you have a collection
}

@AfterClass
public void finalCleanup() {
    //Clean both the index and, for example, a database record.
}