public class DummyJSONModelWrapper<T extends DummyJSONModel> implements Serializable{

    private List<T> dummyJSONModel;

    public DummyJSONModelWrapper(List<T> dummyJSONModel) {
        this.dummyJSONModel = dummyJSONModel;
    }

    public List<T> getDummyJSONModel() {
        return dummyJSONModel;
    }
}