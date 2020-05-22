public class Main {

    public static void main(String[] args) {

        List<Group> groups = new ArrayList<>();
        groups.add(new Group("alex"));
        groups.add(new Group("christan"));
        groups.add(new Group("Dan"));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("bob"));
        persons.add(new Person("Kat"));

        List<BaseClass> members = new ArrayList<>();

        members.addAll(groups);
        members.addAll(persons);
        members.sort(BaseClass::compareTo);

        members.forEach(System.out::println);
    }
}