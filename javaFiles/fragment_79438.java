public class A {
    public static void main(String[] args) throws MalformedURLException {
        String s = "http://xxx.ccc.local/upload/up.php?aa=0&bb=Alvar%E1%2Ffg&cc=1028&from=documentos";

        URL url = new URL(s);
        String protocol = url.getProtocol();
        System.out.println(String.format("A::main: protocol = '%s'", protocol));
    }
}