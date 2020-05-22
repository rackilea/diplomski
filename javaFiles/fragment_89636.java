public class Test implements Comparable<Test> {

    public static void main(String[] args) {
        List<Test> list = new ArrayList<Test>();
        list.add(new Test(1));
        list.add(new Test(2));
        list.add(new Test(3));
        list.add(new Test(4));
        Collections.sort(list);
    }

    private final int number;

    Test(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Test that) {
        System.out.println(this + ".compareTo(" + that + ")");
        return 0;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}