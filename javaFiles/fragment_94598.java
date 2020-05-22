public static class Builder {

  Person.Builder personBuilder;
  private Student reference;

  public Builder(final Student reference) {
    this.reference = reference;
    personBuilder = new Person.Builder(reference);
  }

  public Builder subject(String subject) {
    reference.subjects.add(subject);
    return this;
  }

  // delegation to Person.Builder but return Student.Builder
  public Builder interest(String interest) {
    personBuilder.interest(interest);
    return this;
  }

  // delegation to Person.Builder but return Student.Builder
  public Builder address(String address) {
    personBuilder.address(address);
    return this;
  }

  public Student build() {
    return (Student) personBuilder.build();
  }

}