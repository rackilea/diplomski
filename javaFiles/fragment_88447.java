public class Mock {

    @Size(min=1, max=3)
    private List<String> strings;

    public List<String> getStrings() {
        return strings;
    }

    public void set(List<String> strings) {
        this.strings = strings;
    }

}