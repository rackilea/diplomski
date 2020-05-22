import java.io.File;
import java.net.URL;

class WhatIsMyURI {

    public static void main(String[] args) throws Exception {
        File file = new File("WhatIsMyURI.java");
        // sanity check!
        System.out.println("file.exists(): " + file.exists());
        URL url = file.toURI().toURL();
        System.out.println("url: " + url);
    }
}