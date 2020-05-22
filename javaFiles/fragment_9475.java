public class enc {
    //The Look-Up Table with the position of all the available characters
    public static final String LUT="*, .abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input the sentence you want to encode.");
        String s= sc.nextLine();
    }
}