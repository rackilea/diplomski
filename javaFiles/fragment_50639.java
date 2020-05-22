class Person {      
  @OneToMany( mappedBy = "user" )
  Collection<Personhistory> history;

  ...
}

class Personhistory {
  @ManyToOne
  Person user;

  @ManyToOne
  Team team;

  ...
}