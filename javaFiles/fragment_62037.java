public class X { 
    static { 
        System.out.println("Static free block");
        StackTraceElement [] st  = new RuntimeException("").getStackTrace();
        if( st.length == 1 ) {
            System.out.println("Invoked from main");
        } else { 
            System.out.println("Invoked from somewhere else");
        }
    }
    public static void main( String [] args ) { 
        System.out.println("Main");
    }
}