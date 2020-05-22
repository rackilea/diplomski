import sun.misc.Cleaner;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

...

public static void main(String[] args) throws Exception {
    ByteBuffer direct = ByteBuffer.allocateDirect(1024);
    Field cleanerField = direct.getClass().getDeclaredField("cleaner");
    cleanerField.setAccessible(true);
    Cleaner cleaner = (Cleaner) cleanerField.get(direct);
    cleaner.clean();
}