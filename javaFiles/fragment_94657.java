public class Field {

    private List<SubFieldItems> subFieldItems;

    @JsonValue
    public List<SubFieldItems> getSubFieldItems() {
        return subFieldItems;
    }

    public void setSubFieldItems(List<SubFieldItems> subFieldItems) {
        this.subFieldItems = subFieldItems;
    }
}