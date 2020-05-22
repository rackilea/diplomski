import java.util.Scanner;


public class A {
    public static void main(String[] args) {
        System.out.println("Give a denary number: ");
        Scanner sc = new Scanner(System.in);
        int dec1 = sc.nextInt();
        StringBuilder sb =new StringBuilder();
        String dec = Integer.toString(dec1);
        int zmienna;
        for(int i = 0; i < dec.length(); i++) {
            zmienna = dec1 % 16;
            dec1 = dec1 / 16;
            if(zmienna == 10) {
                //System.out.print("A");
                sb.append("A");
            }
            else if (zmienna == 11) {
                //System.out.print("B");
                sb.append("B");

            }
            else if (zmienna == 12) {
                //System.out.print("C");
                sb.append("C");

            }
            else if (zmienna == 13) {
                //System.out.print("D");
                sb.append("D");

            }
            else if (zmienna == 14) {
                //System.out.print("E");
                sb.append("E");

            }
            else if (zmienna == 15) {
               // System.out.print("F");
                sb.append("F");


            }
            else if (zmienna == 0 & i == dec.length() - 1) {
                System.out.print("");
            }
            else {
                //System.out.print(zmienna);
                sb.append(zmienna);

            }

        }
        System.out.println(sb.reverse());
    }
}