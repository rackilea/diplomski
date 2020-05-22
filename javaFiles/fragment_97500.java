Person person = new MutablePerson("picky");
// someone is cheating:
MutablePerson mutableAgain = (MutablePerson)person;
mutableAgain.setName("Phoenix");

// person.getName().equals("Phoenix") == true