import java.lang.reflect.Method;


public class Test {


    public String stringInstance = "first;second";

    public void Foo() {


        try {
            Object instance = getClass().getDeclaredField("stringInstance").get(this);
            Method m = instance.getClass().getMethod("split", String.class);

            Object returnValue = m.invoke(instance, ";");
            if(returnValue instanceof String[])
            {
                for(String s : (String[])returnValue )
                {
                    System.out.println(s);
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String a[]){
        new Test().Foo();
    }



}