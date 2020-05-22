import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SynchronizedReflectionTest {

public static void main(String[] args) {
    SynchronizedReflectionTest test = new SynchronizedReflectionTest();

    for(int i=0; i<5; i++) {
        final int finalI = i;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Method someThing = SynchronizedReflectionTest.class.getDeclaredMethod("someThing", new Class[]{int.class});
                    someThing.invoke(test, finalI);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

public synchronized void someThing(int nr)
{
    System.out.println("Executing someThing from "+nr);
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Finished executing from nr "+nr);
}