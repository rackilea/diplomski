public void operate(File file) {
    operate(load(file));
}

public void operate(URL url) {
    operate(load(url));
}

public void operate(String data) {
    // operate on the data....
}