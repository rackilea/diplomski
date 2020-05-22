DateTimeFormatter dobFormatter = DateTimeFormatter.ofPattern("ddMMuuuu");
ArrayList<Person> list = new ArrayList <Person> ();
for (int i = 0; i<parsArray.length; i+=4)
    {
        String firstName = parsArray[i];
        String lastName = parsArray[i+1];
        LocalDate dob = LocalDate.parse(parsArray[i+2], dobFormatter);
        String birthPlace = parsArray[i+3];
        System.out.println("\nFirst name: " + firstName + "\nLast name: " + lastName + "\nCity of birth: " + birthPlace);
        list.add (new Person (firstName, lastname, dob, birthPlace));
    }