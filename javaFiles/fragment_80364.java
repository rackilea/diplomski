package com.process;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class ProcessBuilder {
    public static void main(String... args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("D:/test.bat", "firstArg", "secondArg");
        processBuilder.directory(new File("D:/"));
        File log = new File("D:/log.txt");
        builder.redirectErrorStream(true);
        builder.redirectOutput(Redirect.appendTo(log));
        Process p = builder.start();
        p.waitFor();
    }
}