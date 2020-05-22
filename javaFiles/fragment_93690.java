// before Java 9
int data = inputStream.read();
while (data != -1) {
    // doSomething with `data`

    data = inputStream.read(); // read next data
}
inputStream.close(); // or use the try-with-resources syntax