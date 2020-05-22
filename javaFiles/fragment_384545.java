import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        List<Sample> e = new ArrayList<Sample>();
        Sample a1 = new Sample();
        a1.setName("foo1");
        a1.setSex("Male");

        Sample a2 = new Sample();
        a2.setName("foo2");
        a2.setSex("Male");
        e.add(a1);
        e.add(a2);

        String tmpString=e.toString();
        List<Sample> sampleList = (List<Sample>) chengeToObjectList(tmpString, Sample.class);
    }

    /**
     * Method to change String to List<Obj>.
     * @param listString
     * @param contentClass
     * @return List of Objects
     */
    public static Collection chengeToObjectList(String listString, Class contentClass) {

        Collection returnList = new ArrayList();

        // Code to remove [ and ] coming from the toString method
        if (listString.charAt(0) == '[') {
            listString = listString.substring(1);
        }
        if (listString.charAt(listString.length() - 1) == ']') {
            listString = listString.substring(0, listString.length() - 1);
        }

        String[] stringArray = listString.trim().split(",");
        for (int i = 0; i < stringArray.length; i++) {
            String[] contentArray = stringArray[i].trim().split("&");
            Object ob = null;
            try {
                ob = contentClass.newInstance();
            } catch (InstantiationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            for (int j = 0; j < contentArray.length; j++) {

                String[] keyValueArray = contentArray[j].trim().split("=");

                String fieldName = keyValueArray[0].trim();
                //Code to make the 1st char uppercase
                String s = String.valueOf(fieldName.toCharArray()[0]);
                s = s.toUpperCase();
                fieldName = s + fieldName.substring(1);

                String fieldValue = keyValueArray[1].trim();

                Class[] paramTypes = new Class[1];
                paramTypes[0] = String.class;
                String methodName = "set" + fieldName; 
                Method m = null;
                try {
                    m = contentClass.getMethod(methodName, paramTypes);
                } catch (NoSuchMethodException m) {
                    m.printStackTrace();
                }
                try {
                    String result = (String) m.invoke(ob, fieldValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                }
            }
            returnList.add(ob);
        }

        return returnList;
    }
}