@ControllerAdvice
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler
  public ResponseEntity<ApiError> handle(ConstraintViolationException exception) {
        //you will get all javax failed validation, can be more than one
        //so you can return the set of error messages or just the first message
        String errorMessage = new ArrayList<>(exception.getConstraintViolations()).get(0).getMessage();
       ApiError apiError = new ApiError(errorMessage, errorMessage, 1000);    
       return new ResponseEntity<ApiError>(apiError, null, HttpStatus.BAD_REQUEST);
  }
}



@RestController
@Validated
public class MinimumStockController {

    @RequestMapping(value = "/minimumstock")
    public Product product(
            @RequestParam(value = "product.sku", required=false) @NotEmpty(message = "Product.sku cannot be empty") String sku,
            @RequestParam(value = "stock.branch.id", required=false) String branchID) {
        return null;
    }
}