public class ClassVar
{
    public static abstract class Abstract
    {

    }

    public static class Class1 extends Abstract
    {

    }

    public static class Class2 extends Abstract
    {

    }

    /**
     * Given an instance of a child of Abstract, returns a new instance
     * of the same class
     */
    public static Abstract newInstance(Abstract obj) throws InstantiationException, IllegalAccessException
    {
        return obj.getClass().newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException
    {
        System.out.println(newInstance(new Class1()).getClass());
        System.out.println(newInstance(new Class2()).getClass());
    }
}