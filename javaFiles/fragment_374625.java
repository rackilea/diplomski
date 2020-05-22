import java.util.Enumeration;
import java.util.Vector;

public class TestEnumerationCast {

public static void main(String[] args) {
    new TestEnumerationCast();
}

{
    Vector stringVector = new Vector();
    stringVector.add("A");
    stringVector.add("B");
    stringVector.add("C");
    stringVector.add(new Integer(1));

    Enumeration<String> enumerationString2 = castEnumeration(stringVector.elements(), String.class);
    while (enumerationString2.hasMoreElements()) {
        String stringToPrint = enumerationString2.nextElement();
        System.out.println(stringToPrint);
    }

}

private <T> Enumeration<T> castEnumeration(Enumeration<?> elements, Class<T> tClass) {
    Vector<T> converstionVector = new Vector<T>();
    while (elements.hasMoreElements()) {
        try {
            converstionVector.add(tClass.cast(elements.nextElement()));
        } catch (Exception e) {
        }
    }
    return converstionVector.elements();
}

}