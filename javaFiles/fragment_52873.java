$ cat Test.java
import java.io.*;

class Test {
    public static void main(String[] args) throws Exception {
        char[] buff = new char[1048576];
        int numRead = 0;
        Reader reader = new InputStreamReader(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            numRead = reader.read(buff);

            if (numRead == -1) break;
            else sb.append(buff, 0, numRead);
        }

        System.out.println("The buffer contains " + sb.length() + " characters.");
    }
}

$ javac Test.java