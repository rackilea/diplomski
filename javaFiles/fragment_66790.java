import javax.xml.bind.JAXBContext;

public class Demo {

    private static final String MOXY_JAXB_CONTEXT = "org.eclipse.persistence.jaxb.JAXBContext";
    private static final String METRO_JAXB_CONTEXT = "com.sun.xml.bind.v2.runtime.JAXBContextImpl";

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        String jaxbContextImpl = jc.getClass().getName();
        if(MOXY_JAXB_CONTEXT.equals(jaxbContextImpl)) {
            System.out.println("EclipseLink MOXy");
        } else if(METRO_JAXB_CONTEXT.equals(jaxbContextImpl)) {
            System.out.println("Metro");
        } else {
            System.out.println("Other");
        }
    }

}