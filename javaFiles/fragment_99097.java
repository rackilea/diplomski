import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class MainClass {

public static void main(String[] args)
        throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
    theUnsafe.setAccessible(true);
    Unsafe unsafe = (Unsafe) theUnsafe.get(null);


     long ten = 10;
     byte size = 1;
     long mem = unsafe.allocateMemory(size);
     //Put here the wrong address!!!
     unsafe.putAddress(1, ten);
     //With this will work:
     //unsafe.putAddress(mem, ten);
     long readValue = unsafe.getAddress(mem);
     System.out.println("result: " + readValue);
}

}