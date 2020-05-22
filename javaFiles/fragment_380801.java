import java.util.*;
import java.lang.reflect.*;

class Any {
    static int one = 1;
    static int two = 2;
    static int three = 3;

    public static void main( String [] args ) {
          for( int i : magicMethod( Any.class ) ){
              System.out.println( i );
          }
    }

    public static Integer[] magicMethod(Class<Any> c) {
        List<Integer> list  = new ArrayList<Integer>();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getType().equals(int.class) && Modifier.isStatic(field.getModifiers())) {
                    list.add(field.getInt(null));
                }
            }
            catch (IllegalAccessException e) {
                // Handle exception here
            }
        }
        return list.toArray(new Integer[list.size()]);
    }
 }