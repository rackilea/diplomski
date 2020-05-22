public void getNumber(String person) {

    if (this.phonebook.get(person)
        .size() > 1) {
      System.out.println("numbers :");
    }
    for (final String n : this.phonebook.get(person)) {
      System.out.println(n);
    }
  }