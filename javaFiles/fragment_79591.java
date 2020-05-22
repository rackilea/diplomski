public class BuildFileReader() {
    FileReader getReader(String xyz) {
        FileReader reader;

        ...
        your logic
        reader = new WhatEverReaderYouWant();
        ...

        return reader;
    }
}