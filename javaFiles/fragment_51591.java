package mypackage;

import java.io.OutputStream;
import java.io.IOException;

public class NullOutputStream extends OutputStream {
    public void write(int i) throws IOException {
        //do nothing
    }
}