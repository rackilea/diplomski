public class LoopTest {
    public static void main(String [] args) {
        String TER = ",";
        int i=0;
        java.util.Scanner a = new java.util.Scanner(System.in);
        StringBuilder b = new StringBuilder();
        String str;
        System.out.println("Enter a multiple line input"); //opens console window
        while (!(str = a.nextLine()).equals(TER)) {
            b.append(str);//here i am getting the multiple line input
        }
        System.out.println(b.toString());
        String parts[] = b.toString().split("\\ ");
        while(i<parts.length) {
            System.out.println(parts[i]);
            i++;
        }
    }
}