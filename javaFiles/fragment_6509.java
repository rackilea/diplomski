public class StaticVars {

    static int i = 3;

    public static void main( String[] args ) {
        System.out.println( "Called at Runtime: " + getStaticVar() );
        System.out.println( "Called via it's static member: " + i );
    }


    static int getStaticVar() {
        return i;
    }

    static {
        int i = 1;
        System.out.println( "JVM ClassLoaded: " + i );
    }

    static {
        int i = 2;
        System.out.println( "Second JVM ClassLoaded: " + i);
    }

}