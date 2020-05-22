public class SimpleClassifier implements Classifier<InsertUpdateObject, ItemWriter<? extends InsertUpdateObject>> {

    private ItemWriter<? extends InsertUpdateObject> insertWriter;
    private ItemWriter<? extends InsertUpdateObject> updateWriter;

    @Override
    public ItemWriter<? extends InsertUpdateObject> classify(InsertUpdateObject item) {
        if (item.getFlag() == 0) {
            return insertWriter;
        }
        return updateWriter;
    }

    // setters and getters

}