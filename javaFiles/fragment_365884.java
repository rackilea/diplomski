private class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Person t) {
        if(!this.getName().equals(t.getName()))
            return this.getName().compareTo(t.getName());

        return Integer.compare(this.getAge(), t.getAge());
    }
}

private class CustomComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.compareTo(p2);
    }
}

public NewClass()
{
    SortedMap<Person, String> map = new TreeMap<Person, String>(new CustomComparator());

}