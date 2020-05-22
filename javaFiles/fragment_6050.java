Inteface Validatable { void validate() throws InvalidEntityException; }   

Class FKEntity implements Validatable {
  //..
  public void validate() throws InvalidEntityException {
     //your entity specific logic
  }
}

Class FKDigestService {

    public digestEntities() {

      try {
      for(FKEntity e : entityList)
         e.validate();

      //your collective validation logic goes here
      } catch (EntityValidationException e) {//do whatever you want}
    }

}