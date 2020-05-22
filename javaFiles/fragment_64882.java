import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import de.apps.io.AudioManager;


public class Application {

    public static void main(String[] args) {
        System.out.println("hello world");



         Class someInterface1 = null;
        try {
        //  someInterface = AudioManager.class.getDeclaredClasses();

            someInterface1 = Class.forName("de.apps.io.AudioManager$OnAudioPortUpdateListener");
        } catch (Exception e) {
            e.printStackTrace();
        }

         //System.out.println(someInterface);


         System.out.println(someInterface1);



        Object o = Proxy.newProxyInstance(someInterface1.getClassLoader(), new java.lang.Class[] { someInterface1 }, new Handler());


        AudioManager manager = new AudioManager();
        Method me = null;
        try {
            me = manager.getClass().getMethod("registerAudioPortUpdateListener", new java.lang.Class[] { someInterface1 });
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            me.invoke(manager, o);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(me);

    }



    static class Handler implements InvocationHandler
    {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

             String method_name = method.getName();
             Class<?>[] classes = method.getParameterTypes();

             System.out.println("called  " + method_name);

            return null;
        }

    }

}