public class Booleans extends ResourceSupport {

    @JsonProperty("values")
    private List<Boolean> values = new ArrayList<Boolean>();

    public Booleans addValuesItem(Boolean valuesItem) {
        this.values.add(valuesItem);
        return this;
    }

    public List<Boolean> getValues() {
        return values;
    }
    public void setValues(List<Boolean> values) {
       this.values = values;
    }

}