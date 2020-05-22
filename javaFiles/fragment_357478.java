class Patient {

  private final Syringe syringe;

  @Inject
  public Patient(Syringe syringe) {
    System.out.println("That hurt like crazy!");
  }

}