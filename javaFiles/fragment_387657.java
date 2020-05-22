public class DelegateResponse implements Response {

  Response response;

  DelegateResponse(Response response){
    this.response = response;
  }
  .
  .
  .
  // Override and delegate other functions normally, but in the below call, delegate further

  @Override
  ValidatableResponse then(){
    return new DelegateValidatableResponse(response.then(), response);
  }

}

public class DelegateValidatableResponse implements ValidatableResponse {

  ValidatableResponse validatableResponse;
  Response response;

  DelegateValidatableResponse(ValidatableResponse validatableResponse,Response response) {
    this.validatableResponse = validatableResponse;
    this.response = response;
  }
  .
  .
  .
  // Override and delegate other functions similarly and wrap with try catch
  // This gives us access to Response object if an exception is thrown and we have more details
  // than just the String "Expected status code 200 but was 500"

  @Override
  public ValidatableResponse statusCode(Matcher<? super Integer> expectedStatusCode) {
    try {
      return validatableResponse.statusCode(expectedStatusCode);
    } catch (Throwable exception) {
      throw new ApiValidationError(response, requestSpec, responseSpec, exception);
    }
  }

}