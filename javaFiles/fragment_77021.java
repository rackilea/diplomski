class TestClass
{
    private String x;
    private int y;
    private boolean z;
}
public class Test
{
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException 
    {
        Class clazz = TestClass.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) 
        {
            System.out.println("fieldName: "+field.getName()+", fieldType: "+field.getType());
        }
    }
}