public class Test implements Comparable<Test>{

    int age;
    int money;
    int id;

    Comparator<Test> comp = Comparator.<Test>comparingInt(x -> x.age)
                                            .thenComparingInt(x -> x.money)
                                            .thenComparingInt(x -> x.id);

    public Test(int age, int money, int id) {
        this.age = age;
        this.money = money;
        this.id = id;
    }

    public static void main(String... args) {

        Test t1 = new Test(25,200,3);
        Test t2 = new Test(30,50,5);
        Test t3 = new Test(15,90,9);

        Set<Test> set = new TreeSet<>();

        set.add(t1);
        set.add(t2);
        set.add(t3);

        System.out.println(set); // [Test{age=15, money=90, id=9}, Test{age=25, money=200, id=3}, Test{age=30, money=50, id=5}]
    }

    @Override
    public String toString() {
        return "Test{" + "age=" + age + ", money=" + money + ", id=" + id + '}';
    }

    @Override
    public int compareTo(Test o) {
        return comp.compare(this, o);
    }

}