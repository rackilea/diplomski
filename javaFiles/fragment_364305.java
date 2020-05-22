public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ho = "Ho";
        int n = s.nextInt();
        System.out.println(repeat(ho, n) + "!");
    }

    public static String repeat(String str, int times) {
        StringBuilder builder=new StringBuilder();
        for(int i=0 ; i<times ; i++){
            builder.append(str).append(" ");
        }
        return builder.toString().trim();
    }
}