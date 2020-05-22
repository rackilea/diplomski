import java.io.IOException;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;

public class JaxbResult implements Result {
    private static final long serialVersionUID = -5195778806711911088L;
    public static final String DEFAULT_PARAM = "jaxbObjectName";

    private String jaxbObjectName;

    public void execute(ActionInvocation invocation) throws Exception {
        Object jaxbObject = getJaxbObject(invocation);
        Marshaller jaxbMarshaller = getJaxbMarshaller(jaxbObject);
        Writer responseWriter = getWriter();

        setContentType();
        jaxbMarshaller.marshal(jaxbObject, responseWriter);
    }

    private Writer getWriter() throws IOException {
        return ServletActionContext.getResponse().getWriter();
    }

    private Marshaller getJaxbMarshaller(Object jaxbObject) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(jaxbObject.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        return jaxbMarshaller;
    }

    private Object getJaxbObject(ActionInvocation invocation) {
        ValueStack valueStack = invocation.getStack();

        return valueStack.findValue(getJaxbObjectName());
    }

    private void setContentType() {
        ServletActionContext.getResponse().setContentType("text/xml");
    }

    public String getJaxbObjectName() {
        return jaxbObjectName;
    }

    public void setJaxbObjectName(String jaxbObjectName) {
        this.jaxbObjectName = jaxbObjectName;
    }
}