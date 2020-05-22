class Person { 
    private final String name;
    private final int age;

    public static int compareByAge(Person a, Person b) { ... }

    public static int compareByName(Person a, Person b) { ... }
}

Person[] people = ...
Arrays.sort(people, Person::compareByAge);