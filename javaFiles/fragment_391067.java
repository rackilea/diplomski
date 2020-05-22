import java.util.*;
import java.io.*;

class Example {
    public static void main(String[] args) throws Exception {
        Set<Object> theSet = new LinkedHashSet<>();
        final int size = 3;

        for(int i = 0; i < size; ++i) {
            theSet.add(i);
        }

        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
        ObjectOutputStream objectsOut = new ObjectOutputStream(bytesOut);

        for(int i = 0; i < size; ++i) {
            objectsOut.writeObject(theSet);
            theSet.remove(i); // mutate theSet for each write
        }

        ObjectInputStream objectsIn = new ObjectInputStream(
            new ByteArrayInputStream(bytesOut.toByteArray()));

        for(;;) {
            try {
                System.out.println(((Set<?>)objectsIn.readObject()).size());
            } catch(EOFException e) {
                break;
            }
        }
    }
}