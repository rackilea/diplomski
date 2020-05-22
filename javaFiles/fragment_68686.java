public class B {

    public static void main(String[] args) {            
        int x = 5;
        String y = "h";
        String result = new String(new char[x]).replace("\0", y);
        System.out.println(result);
    }
}