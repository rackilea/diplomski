public static void main(String a[]){

    List<NameAge> entries = new ArrayList<>();
    entries.add( new NameAge("Zack", 2) );
    entries.add( new NameAge("John", 37) );
    entries.add( new NameAge("John", 11) );
    entries.add( new NameAge("John", 5) );
    entries.add( new NameAge("Andrew", 9) );

    Collections.sort(entries);

    for (NameAge each : entries) {
        System.out.println(each.name + " (" + each.age + ")");
    }
}

public static class NameAge implements Comparable<NameAge> {
    String name;
    int age;

    public NameAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo( NameAge other) {
        int nc = name.compareToIgnoreCase( other.name );
        if (nc != 0) {
            return nc;
        }
        return (age < other.age) ? -1 : ((age > other.age) ? 1 : 0);
    }
}