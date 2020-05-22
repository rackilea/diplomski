public class CustomerNotFoundException extends WebApplicationException {

    /**
    * Create a HTTP 404 (Not Found) exception.
    */
    public CustomerNotFoundException() {
      super(Responses.notFound().build());
    }

    /**
    * Create a HTTP 404 (Not Found) exception.
    * @param message the String that is the entity of the 404 response.
    */
    public CustomerNotFoundException(String message) {
      super(Response.status(Responses.NOT_FOUND).
      entity(message).type("text/plain").build());
    }
}