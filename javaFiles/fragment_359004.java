@WebService(wsdlLocation = "....")
@DataBinding(org.apache.cxf.databinding.source.SourceDataBinding.class)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE) 
public class HelloWorldImpl implements HelloWorld {
     public Source sayHi(Source xml) {
        return xml;
    }
}