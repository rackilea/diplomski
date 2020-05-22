Exception in thread "main" java.lang.NullPointerException
    at inheritance.parent.Child.main(Child.java:45)

import org.xml.sax.SAXException;

public class Child  {

public static void main(String[] args) throws SAXException {

        try{
        Child c1 = null;
        c1.i=0;

        } catch(Exception e){
            throw new SAXException("Error", e); //Line : 45
        }
    }
}