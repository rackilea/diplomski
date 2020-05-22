import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class WritesOutTestUsingStub {

    @Test
    public void testDoIt() throws Exception {
        //Redirect System.out to buffer
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        MockOut.doIt();
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray()); 
        assertTrue(allWrittenLines.contains("did it!"));
    }

}