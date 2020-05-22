public class Test implements Comparable<Test>{

    private int age;
    private int money;
    private int id;

    private final Comparator<Test> comp = Comparator.<Test>comparingInt(Test::getId)
                                            .thenComparingInt(Test::getMoney)
                                            .thenComparingInt(Test::getAge);

    public static void main(String... args) {

        Test t1 = new Test(25, 200, 3);
        Test t2 = new Test(30, 50, 5);
        Test t3 = new Test(15, 90, 9);

        Set<Test> set = new TreeSet<>();

        set.add(t1);
        set.add(t2);
        set.add(t3);

        System.out.println(set); // [Test{age=25, money=200, id=3}, Test{age=30, money=50, id=5}, Test{age=15, money=90, id=9}]
    }

    public Test(int age, int money, int id) {
        this.age = age;
        this.money = money;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Test o) {
        return comp.compare(this, o);
    }

    @Override
    public String toString() {
        return "Test{" + "age=" + age + ", money=" + money + ", id=" + id + '}';
    } 
}