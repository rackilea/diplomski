public class Main {

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY 
    }

    public <E extends Enum<E>> E doSomething(E operation, Class<E> klazz) {

        return operation;
    }

    public static void main(String[] args) {

        new Main().doSomething(Day.FRIDAY, Day.class);
    }

}