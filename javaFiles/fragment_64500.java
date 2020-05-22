public class CastingTest {

    public static void cast(Object o) throws IllegalArgumentException, IllegalAccessException{
        Class<? extends Object> clazz = o.getClass();
        //clazz.cast(o);
        System.out.println(clazz.getName() + " >> " + clazz.getDeclaredFields().length);
        for(Field f: clazz.getDeclaredFields()){
            f.setAccessible(true);
            System.out.println( f.getName()  + "=" + f.get(o));
        }
    }

    public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException{
        CastingTest.cast(new ClassA("A","B",1));
        CastingTest.cast(new ClassB("A","B",2.25));
    }
}