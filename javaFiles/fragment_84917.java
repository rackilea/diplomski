public class UserSearchMain {
    static class Person {
        int id;
        int dateOfBirth;

        static Person[] generatePeople(int num) {
            Random rand = new Random();
            Person[] people = new Person[num];
            for (int i = 0; i < num; i++) {
                Person p = new Person();
                p.id = i;
                p.dateOfBirth = rand.nextInt(80 * 365); // any day for 80 years.
                people[i] = p;
            }
            return people;
        }
    }

    public static void main(String... args) {
        Person[] people = Person.generatePeople(5000);
        List<List<Person>> peopleByDOB = new ArrayList<List<Person>>();
        for (Person person : people) {
            int dob = person.dateOfBirth;
            while (peopleByDOB.size() <= dob) peopleByDOB.add(new ArrayList<Person>());
            peopleByDOB.get(dob).add(person);
        }

        Random rand = new Random();

        int warmup = 12 * 1000;
        int runs = 1000 * 1000;
        long start = 0;

        for (int i = -warmup; i < runs; i++) {
            if (i == 0) start = System.nanoTime();
            int dayToSearch = rand.nextInt(80 * 365);
            for (int j = Math.max(0, dayToSearch - 7); j <= dayToSearch + 7 && j < peopleByDOB.size(); j++) {
                List<Person> peopleWithCloseDOM = peopleByDOB.get(j);
            }
        }
        long time = System.nanoTime() - start;
        System.out.printf("Each search took an average of %,d ns%n", time / runs);
    }
}