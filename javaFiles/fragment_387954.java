package tests;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static native void helloJre();

    public static void main(String[] args) {
        Path p = Paths.get("libtest.dylib");
        System.load(p.toAbsolutePath().toString());
        Test.helloJre();
    }
}