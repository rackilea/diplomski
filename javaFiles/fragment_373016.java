public class Person {
    String first;
    String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String toString() {
        String result = first + "\n";
        result += last + "\n";

        return result;
    }
}