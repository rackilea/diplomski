public class A{
    public static long fa(byte[]b){
        return b.length;
    }
    static class B{
        byte[] b="123".getBytes();
        long fb(){
            return fa(b); // <<< line 9
        }
    }

    public static void main(String [] arg){
        System.out.println ( ">>>" + new B().fb() );
    }
}