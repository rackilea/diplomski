while ((sCurrentLine = br.readLine()) != null) {
    Scanner scanner = new Scanner(sCurrentLine);
    String firstName = scanner.next();
    String lastName = scanner.next();
    int age = scanner.nextInt();
    int dob = scanner.nextInt();
    people.add(new Person(firstName, lastName, age, dob);
}