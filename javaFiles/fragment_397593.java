public abstract class ValidateController<T> {

  private Validator<T> validator;

  ValidateController(Validator<T> validator){
     this.validator = validator;
  }

  @RequestMapping("/")
  public void index(T t) {
    boolean isValid = validator.validate(t);
  }

}