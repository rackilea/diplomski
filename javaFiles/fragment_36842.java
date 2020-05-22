public class StackOverFlow {
 public static String[] CONSOLES = {
            "PC",
            "PS4",
            "XBOX ONE",
            "PS VITA"
        };

 public static void main(String arg[]){

    System.out.println(getConsoleName(0));


} 


public static String getConsoleName(int ID)
{
    String rtext = "unknown";
    try {
        rtext = CONSOLES[ID];
    } catch (Exception e) {
        System.err.println(e);
    }
    return rtext;
}