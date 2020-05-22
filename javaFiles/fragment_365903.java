do {
    System.out.println("Name: ");
    personName = data.nextLine();
    if (personName.isEmpty()) {
        System.out.println("Please enter your name. ");
    }else {
        personName  = personName.toUpperCase();//String is immutable
        p.setName(personName);
    }
} while (personName.isEmpty())