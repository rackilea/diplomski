try (FileInputStream fis = new FileInputStream(filePerson)) {
    ObjectInputStream ois = new ObjectInputStream(fis);
    int p = ois.readInt();
    Person[] persons = new Person[p];
    for (int i = 0; i < p; i++) {
        persons[i] = (Person)ois.readObject();
    }
    ois.close();
}