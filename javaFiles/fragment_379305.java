public class Program
{
    public static void main(String[] args) {
        String str = "This is a string.\nThis is a long string.";
        str = str.replaceAll("(\r\n|\n)", "<br />");
        System.out.println(str);
    }
}