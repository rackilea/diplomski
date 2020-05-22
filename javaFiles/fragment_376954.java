import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ObjectAddress {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object[] os = {o1, o2, o3};
        System.out.println("Before using hashCode");
        for (int i = 0; i < os.length; i++) {
            int address = UNSAFE.getInt(os, UNSAFE.arrayBaseOffset(Object[].class) + i * 4);
            int hashCode = UNSAFE.getInt(os[i], 1L);
            System.out.println(i + ": " + Integer.toHexString(address) + " hashCode " + Integer.toHexString(hashCode));
            os[i].hashCode();
        }
        System.out.println("After using hashCode");
        for (int i = 0; i < os.length; i++) {
            int address = UNSAFE.getInt(os, UNSAFE.arrayBaseOffset(Object[].class) + i * 4);
            int hashCode = UNSAFE.getInt(os[i], 1L);
            System.out.println(i + ": " + Integer.toHexString(address) + " hashCode " + Integer.toHexString(hashCode) + " for " + os[i]);
            UNSAFE.putInt(os[i], 1L, 0x12345678);
        }
        System.out.println("After setting the hashCode");
        for (int i = 0; i < os.length; i++) {
            int address = UNSAFE.getInt(os, UNSAFE.arrayBaseOffset(Object[].class) + i * 4);
            int hashCode = UNSAFE.getInt(os[i], 1L);
            System.out.println(i + ": " + Integer.toHexString(address) + " hashCode " + Integer.toHexString(hashCode) + " for " + os[i]);
            os[i].hashCode();
        }

    }

    static final Unsafe UNSAFE;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}