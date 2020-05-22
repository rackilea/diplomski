import java.util.List;

public class Child {

    private List<String> strings;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        System.out.println("setStrings");
        this.strings = strings;
    }

}