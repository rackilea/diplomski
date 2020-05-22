public class Foo {

    class You {
        public You(String s){}
    }

    public static void main(String[] args)  throws NoSuchMethodException {
        Constructor[] constructors = You.class.getConstructors();

        for (Constructor constructor: constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();

            for (Class c: parameterTypes){
                System.out.println(c.getName());//print java.lang.String
            }
        }

        Constructor constructor =
            You.class.getConstructor(String.class);//NoSuchMethodException?
    }
}