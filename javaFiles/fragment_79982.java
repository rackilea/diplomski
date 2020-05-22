public class A{
    private int myMember;
    ...
}

public class B{
    private A myA;

    private int get(){
        try {
             Field field = myA.getClass().getDeclaredField("myMember");
             field.setAccessible(true);
             return (int) field.get(myA);
        catch (Exception e){
             //Something went wrong, the field doesn't exist or a security exception
             return null; //or return some "error number" like -10
        }
    }



}