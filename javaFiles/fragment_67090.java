public abstract class SomeSuperClass {

    public SomeSuperClass someMethod(SomeSuperClass otherClass) throws InstantiationException, IllegalAccessException {
        return otherClass.getClass().newInstance();
    }

    public static void main(String[] args) {
        SomeSubClass subClass = new SomeSubClass();
        try {
            SomeSuperClass newClass = subClass.someMethod(subClass);
            System.out.println(newClass.getClass().getName());
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}