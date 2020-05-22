class Person implements Comparable<Person> {

    @Override
    public int compareTo(Person o) {
        return Long.compare(this.getAge(), o.getAge());
    }
}