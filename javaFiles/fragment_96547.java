package com.file.loader;

public class Main {
    public static void main(String[] args) throws IOException {
    InputStream in = Main.class.getClassLoader().getResourceAsStream(
            "com/file/loader/data.txt");
    }
}