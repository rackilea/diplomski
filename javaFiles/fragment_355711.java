int currentAge = -1;
String currentSex = null;

for (Person person : persons) {
    if (person.getAge() != currentAge) {
        currentAge = person.getAge();
        currentSex = null;
        System.out.println(person.getAge());
    }
    if (!person.getSex().equals(currentSex)) {
        currentSex = person.getSex();
        System.out.println("\t" + person.getSex());
    }

    System.out.println("\t\t" + person.getName());
}