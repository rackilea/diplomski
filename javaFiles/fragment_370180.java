public class DemoClass {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("cmd /c command1 && command2 && command3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}