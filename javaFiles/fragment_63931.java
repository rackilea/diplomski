package forum11769758;

import javax.xml.bind.*;

public class Test {

    public static void main(String[] args) throws Exception {
        MyClass l1 = new MyClass(1, "Level 1");
        MyClass l2 = new MyClass(2, "Level 2");
        l1.addChild(l2);
        MyClass l3 = new MyClass(3, "Level 3");
        l2.addChild(l3);

        JAXBContext jc = JAXBContext.newInstance(MyClass.class);
        Marshaller marshaller = jc.createMarshaller();
        MyClassAdapter myClassAdapter = new MyClassAdapter(2);
        marshaller.setAdapter(myClassAdapter);
        marshaller.setListener(myClassAdapter.getMarshallerListener());
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(l1, System.out);
    }

}