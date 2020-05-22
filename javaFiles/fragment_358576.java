import java.util.ArrayList;


public class One {

    private ArrayList<Integer> list = new ArrayList<Integer>();

    public One() {
        addString(list);
        sysoutList(list);
    }

    public void sysoutList(ArrayList<Integer> list2) {
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }

    private void addString(ArrayList<Integer> list2) {
        list2.removeAll();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
    }

}