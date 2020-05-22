public class ResourceToString {
public static void main(String[] args) {
    String pi  = convertStreamToString(ResourceToString.class.getClassLoader().getResourceAsStream("pi.txt"));
    System.out.println(pi);

}
private static String convertStreamToString(java.io.InputStream is) {
    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
    return s.hasNext() ? s.next() : "";
}
}