package dummy;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Child extends Parent implements Serializable
{

private String attribute;

private List<String> values = new ArrayList<String>();

/**
 * @return the attribute
 */
public String getAttribute()
{
    return attribute;
}

/**
 * @param attribute
 *            the attribute to set
 */
public void setAttribute(String attribute)
{
    this.attribute = attribute;
}

/**
 * @return the values
 */
public List<String> getValues()
{
    return values;
}

/**
 * @param values
 *            the values to set
 */
public void setValues(List<String> values)
{
    this.values = values;
}

public static void main(String[] args) throws JAXBException
{
    JAXBContext context = JAXBContext.newInstance(Parent.class);

    Child child = new Child();
    child.setAttribute("dummy");
    child.setValues(Arrays.asList("value1", "value2"));

    StringWriter writer = new StringWriter();

    context.createMarshaller().marshal(child, writer);

    System.out.println(writer.getBuffer().toString());

    Child unmarshalledChild = (Child) context.createUnmarshaller().unmarshal(new    ByteArrayInputStream(writer.getBuffer().toString().getBytes()));
    System.out.println("attribute: " + unmarshalledChild.attribute);
    System.out.println("values: " + unmarshalledChild.values);

}