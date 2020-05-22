public class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2>> implements Comparable<Pair<T1, T2>> {
    T1 firstName;
    T2 secondName;

    public Pair(T1 firstName, T2 secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public T1 getFirstName() {
        return firstName;
    }

    public T2 getSecondName() {
        return secondName;
    }

    // elements ordered with first parameter .you can make a better
    // comparable as well
    @Override
    public int compareTo(Pair<T1, T2> o) {
        // TODO Auto-generated method stub
        return this.firstName.compareTo(o.firstName);
    }

}