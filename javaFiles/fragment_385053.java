class Car extends MechanicalObject {
  @OneToMany( mappedBy="parent" )
  protected List<Driver> potentialDrivers; 
}

class Driver {
  @ManyToOne
  protected Car parent; //I'd use a better name here
}