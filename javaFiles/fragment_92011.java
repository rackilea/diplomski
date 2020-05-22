class PersonPredicate {
  public Predicate<Person> isAdultMale() {
    return p -> 
            p.getAge() > ADULT
            && p.getSex() == SexEnum.MALE;
  }
}