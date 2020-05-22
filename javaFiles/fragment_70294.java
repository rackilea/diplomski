public class Main {

    public static void main(String[] args) {

        Person a = new Person("smith", "joe", 25, 1.57, "male");
        Person b = new Person("davis", "sian", 18, 1.73, "female");

        List<Person> persons = new ArrayList<Person>();
        persons.add(a);
        persons.add(b);

        for(Person p : persons){    
            System.out.format("%s   %s   %s   %d   %.2f   %s", p.getClass().getName(), p.getSurname(), p.getForname(), p.getAge(), p.getHeight(), p.getGender());
            System.out.println();
        }   
    }
}