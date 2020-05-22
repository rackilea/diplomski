List<String> peoplFname = Arrays.asList("Firstname1", "Firstname2", "Firstname3");
List<String> peoplLname = Arrays.asList("Lastname1", "Lastname2", "Lastname3");

Iterator<String> iterator = peoplFname.iterator();
Iterator<String> iteratorx = peoplLname.iterator();

List<String> peopleFullName = new ArrayList<String>(); 

while(iterator.hasNext() && iteratorx.hasNext()) {
    String fullName = iterator.next() + " " + iteratorx.next();
    peopleFullName.add(fullName);
}

System.out.println(peopleFullName);