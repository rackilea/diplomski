public class small_cap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String st = sc.nextLine();
        String str = " " + st;

        int j = 0; char chr = ' ';

        for (int i = 0; i < str.length()-1; i++){
           j = i+1;

            chr = str.charAt(i);
            if (chr == ' '){
                char a = Character.toUpperCase(str.charAt(j));
                str = str.substring(0,j)+a+str.substring(j+1);
            }
            else{
                char a = Character.toLowerCase(str.charAt(j));
                str = str.substring(0,j)+a+str.substring(j+1);
            }
        }
        System.out.println(str);
    }