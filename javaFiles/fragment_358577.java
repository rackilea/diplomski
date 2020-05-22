import java.util.ArrayList;


public class One {

    private static ArrayList<Integer> list;

    public One() {
        addString();
        sysoutList();
    }

    public void sysoutList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private void addString() {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

}