// imports (for your reference)
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// spring controller method
@RequestMapping(value = "getcust/{custid}", method = RequestMethod.GET, produces={"application/json"})
public ResponseEntity<Customer> getToken(@PathVariable("custid") final String custid, HttpServletRequest request) {

    customer = service.getCustById(custid);

    return new ResponseEntity<Customer>(customer, HttpStatus.OK);
}