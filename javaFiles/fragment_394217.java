import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.lang.reflect.Field;

public class Example
{
    public abstract static class JAXBAutoNullifierForEmptyOptionalFields
    {
        void beforeMarshal(Marshaller x)
        {
            try
            {
                for (Field field : this.getClass().getFields())
                {
                    final XmlElement el = field.getAnnotation(XmlElement.class);

                    // If this is an optional field, it has a value & it has no fields populated then we should replace it with null
                    if (!el.required())
                    {
                        if (JAXBAutoNullifierForEmptyOptionalFields.class.isAssignableFrom(field.getType()))
                        {
                            final JAXBAutoNullifierForEmptyOptionalFields val = (JAXBAutoNullifierForEmptyOptionalFields) field.get(
                                    this);

                            if (val != null && !val.hasAnyElementFieldsPopulated())
                                field.set(this, null); // No fields populated, replace with null
                        }
                    }
                }
            }
            catch (IllegalAccessException e)
            {
                throw new RuntimeException("Error determining if class has all required fields: " + this, e);
            }
        }


        boolean hasAnyElementFieldsPopulated()
        {
            for (Field field : this.getClass().getFields())
            {
                try
                {
                    if (field.isAnnotationPresent(XmlElement.class))
                    {
                        // Retrieve value
                        final Object val = field.get(this);

                        // If the value is non-null then at least one field has been populated
                        if (val != null)
                        {
                            return true;
                        }
                    }
                }
                catch (IllegalAccessException e)
                {
                    throw new RuntimeException("Error determining if class has any populated JAXB fields: " + this, e);
                }
            }

            // There were no fields with a non-null value
            return false;
        }
    }

    @XmlRootElement
    public static class MyJAXBType extends JAXBAutoNullifierForEmptyOptionalFields
    {
        @XmlElement
        public String someField;

        @XmlElement
        public MyJAXBType someOtherField;


        public MyJAXBType()
        {
        }


        public MyJAXBType(final String someField, MyJAXBType someOtherField)
        {
            this.someField = someField;
            this.someOtherField = someOtherField;
        }
    }


    public static void main(String[] args) throws Exception
    {
        final Marshaller marshaller = JAXBContext.newInstance(MyJAXBType.class).createMarshaller();

        MyJAXBType innerValue = new MyJAXBType(); // Unpopulated inner value
        MyJAXBType value = new MyJAXBType("some text value", innerValue);

        final StringWriter sw = new StringWriter();

        marshaller.marshal(value, sw); // Omits "someOtherField"

        System.out.println(sw.toString());
    }
}