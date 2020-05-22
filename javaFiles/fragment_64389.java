package org.openuri;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService
public interface ExampleService {

    @WebMethod
    @SOAPBinding(parameterStyle=ParameterStyle.BARE)
    GetPostDirectionalResponse getPostDirectional(String input);
}