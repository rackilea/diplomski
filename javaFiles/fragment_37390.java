import java.util.Arrays;

public class DemoTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyClass[] array = new MyClass[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new MyClass(String.valueOf(i), String.valueOf(i + 10), i + 20);
        }

        // sort before binary search
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, new MyClass("5", "15"));
        if (index > -1) {
            System.out.println("found at " + index);
        } else {
            System.out.println("not found");
        }

        index = Arrays.binarySearch(array, new MyClass("6", "15"));
        if (index > -1) {
            System.out.println("found at " + index);
        } else {
            System.out.println("not found");
        }

    }
}

class MyClass implements Comparable<MyClass> {
    private String a;
    private String b;
    private int c;

    public MyClass(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public MyClass(String a, String b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }   


    @Override
    public int compareTo(MyClass o) {
        int result = this.a.compareTo(o.a);
        if (result == 0) {
            return this.b.compareTo(o.b);
        } else {
            return result;
        }
    }

}