class PersonPredicate {
  public Predicate<Person> isAdultMale() {
    return isAdult().and(isMale());
  }

  publci Predicate<Person> isAdultFemale() {
    return isAdult().and(isFemale());
  }

  public Predicate<Person> isAdult() {
    return p -> p.getAge() > ADULT;
  }

  public Predicate<Person> isMale() {
    return isSex(SexEnum.MALE);
  }
  public Predicate<Person> isFemale() {
    return isSex(SexEnum.FEMALE);
  }
  public Predicate<Person> isSex(SexEnum sex) {
    return p -> p.getSex() == sex;
  }
}