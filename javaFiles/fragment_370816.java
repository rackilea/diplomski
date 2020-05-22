abstract class BaseClass implements Comparable{ // you could name this class as you want
    protected String name;

    @Override
    public int compareTo(Object o) {
        return this.name.compareToIgnoreCase(((BaseClass)o).name);
    }
}

class Group extends BaseClass{
    public Group(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "groupName : " + name;
    }
}

class Person extends BaseClass{
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "personName : " + name;
    }
}