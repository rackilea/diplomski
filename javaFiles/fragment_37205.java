private Car car;
private @EJB CarFacade carFacade;

public RegistrationController() {
    this.car = new Car();
}

public String save() {
    carFacade.create(car);
    return "someoutcome";
}

// ...