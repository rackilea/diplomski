private String file(String fileName){...}
private void nGram(String valueFromFile){...}

public static void main(String[] args) throws Exception {
    ...

    Example e = new Example(fileName, k);
    e.nGram(e.file(fileName));
}