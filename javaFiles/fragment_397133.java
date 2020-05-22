List<Person> people = new ArrayList<>(25);
//...
while ((sCurrentLine = br.readLine()) != null) {
    String parts[] = currentLine.split(";");
    String firstName = parts[0];
    String lastName = parts[1];
    String age = parts[2];
    String dob = parts[3];
    people.add(new Person(firstName, lastName, Integer.parseInt(age), Integer.parseInt(dob));
}