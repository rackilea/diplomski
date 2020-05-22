import java.lang.reflect.Field;
import java.lang.reflect.Type;

class Test 
{
    public String s;
    public int member = 1;
    public byte try1 = 0;
    public int member2 = 4;

    public static void main(String []args)
    {
        Test o = new Test ();
        Field[] fields = o.getClass().getFields();
        for (Field field : fields) {                
            Class<?> type = field.getType();
            if (type.equals(byte.class)) {
                System.out.println("byte"); 
            } else if (type.equals(int.class)) {
                System.out.println("int");
            } else {
                System.out.println("something else");
            }    
        }
    }
}