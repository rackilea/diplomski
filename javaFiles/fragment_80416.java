@lombok.AllArgsConstructor
@lombokGetter
class ErrorInformation {

   private final transient Exception exception;
   private final String errorMessage ;
   ErrorInformation(Exception exp) {
    this.exception = exp;
    this.errorMessage = exp.getMessage();
    }

}