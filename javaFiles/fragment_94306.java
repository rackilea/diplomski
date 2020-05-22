package calc.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import calc.util.NumberFormater;

/**
* @author Bikash Shaw
*/
@WebService()
public class JSimpCalcWebService {

/**
  * Web service operation
  */
  @WebMethod(operationName = "addition")
  public String addition(@WebParam(name = "parameter1")
  double parameter1, @WebParam(name = "parameter2")
  double parameter2) {
 //TODO write your implementation code here:
      return NumberFormater.format((parameter1 + parameter2),0,6);
 }