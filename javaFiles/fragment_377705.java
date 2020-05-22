public class Echo {
    public static void main (String[] args) {
        for (String s: args) {
            System.out.println(s);
            Socket socket;
            socket = new Socket(s, 16789);
        }
    }
}