import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Entry implements Comparable<Entry> {
private int num;
private String val;

public Entry() {
    this.num = 0;
    this.val = "";
} 

public void setNum(int num) {
    this.num = num;
}

public int getNum() {
    return this.num;
}

@Override
public int compareTo(Entry entry) {
    if (this.num < entry.num) return -1;
    if (this.num > entry.num) return 1;
    return 0;
}

public static void main(String[] args) {
    System.out.println("TEST 1");
    test1();

    System.out.println("\nTEST 2");
    test2();
}

public static void test1() {
    Entry e1 = new Entry();
    e1.setNum(5);

    Entry e2 = new Entry();
    e2.setNum(4);
    System.out.println("e1 = " + e1.getNum() + ", e2 = " + e2.getNum() + ", e1.compareTo(e2) = " + e1.compareTo(e2));

    Entry e3 = new Entry();
    e3.setNum(5);
    System.out.println("e1 = " + e1.getNum() + ", e3 = " + e3.getNum() + ", e1.compareTo(e3): " + e1.compareTo(e3));

    Entry e4 = new Entry();
    e4.setNum(6);
    System.out.println("e1 = " + e1.getNum() + ", e4 = " + e4.getNum() + ", e1.compareTo(e4): " + e1.compareTo(e4));
}

public static void test2() {
    List<Entry> list = new ArrayList<Entry>();
    int[] nums = { 5, 3, 9, 25, 1, -8 };
    for (int i : nums) {
        Entry e = new Entry();
        e.setNum(i);
        list.add(e);
    }
    Collections.sort(list);

    System.out.print("Orig list: ");
    for (int i : nums) {
        System.out.print(i + ", ");
    }

    System.out.println();

    System.out.print("Sorted list: ");
    for (Entry e : list) {
        System.out.print(e.getNum() + ", ");
    }

}
}