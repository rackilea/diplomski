package test;

import java.io.*;

public class SUT {

    public String doSomething() throws IOException {
        InputStreamReader reader =
                new InputStreamReader(getFileAsStream(null, null));
        BufferedReader bReader =
                new BufferedReader(reader);

        return bReader.readLine();
    }

    private InputStream getFileAsStream(Object resourceResolver, Object iconPath)
            throws FileNotFoundException {
        return new ByteArrayInputStream("".getBytes());
    }
}