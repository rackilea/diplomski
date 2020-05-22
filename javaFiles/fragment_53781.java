import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("x");
        list.add("y");
        list = (LinkedList<String>) list.subList(1, 2);
    }
}