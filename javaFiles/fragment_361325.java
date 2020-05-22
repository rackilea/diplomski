public class Person {

    private String name;
    private String age;

    public Person(String name,String age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person person){
        this.name = person.getName();
        this.age= person.getAge();
    }

    public Person(){    
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "[Name:"+this.name+"][Age:"+this.age+"]";
    }

    public static void main(String[] args) {

        Person person1 = new Person("Charles","20");
        Person person2 = new Person("Rob","30");

        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);

        List<Person> morePersons = new ArrayList<Person>();
        morePersons.add(new Person(person1));
        morePersons.add(new Person(person2));

        Person newobj = new Person();
        for (Person obj : persons) {
            if (obj.getName().equals("Charles")) {
                newobj = obj;
                newobj.setAge("10");
            }
        }

        System.out.println(persons);
        System.out.println("======");
        System.out.println(morePersons);

    }
}