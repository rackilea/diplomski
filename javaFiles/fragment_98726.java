public class Student {
    private final String name;
    private final int number;
    private final int prizeMoney;

    public Student(final String name, final int number, final int prizeMoney) {
        this.name = name;
        this.number = number;
        this.prizeMoney = prizeMoney;
    }

    @Override
    public String toString() {
        return name+"%"+number+"%"+prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}