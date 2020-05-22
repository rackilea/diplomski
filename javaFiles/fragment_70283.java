protected <T> T doInsert(String collectionName, T objectToSave, MongoWriter<T> writer) {
        BeforeConvertEvent<T> event = new BeforeConvertEvent(objectToSave, collectionName);
        T toConvert = ((BeforeConvertEvent)this.maybeEmitEvent(event)).getSource(); //emit event
        toConvert = this.maybeCallBeforeConvert(toConvert, collectionName); //call some before convert handlers
        ...
}