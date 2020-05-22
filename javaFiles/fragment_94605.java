// Return compilation log!
public String compile(){     
    Process p = null;
    try {
        p = Runtime.getRuntime().exec("javac src/Teste.java");
        p.waitFor();
    } catch (IOException e) {

    } catch (InterruptedException e) {

    }

    Scanner scanner = new Scanner(p.getInputStream());
    String result = null;

    try{
        result = scanner.useDelimiter("$$").next();
    } catch (NoSuchElementException e) {

    }
    scanner.close();

    return result;
}