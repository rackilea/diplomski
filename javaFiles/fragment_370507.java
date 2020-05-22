public class anArray {
    public static void main(String[]args) {
        int [] x = {2, 3, 4, 4, -5, 4, 6, 2};
        int count =0;
        for (int i=0; i<x.length; i++) {
            if (x[i] == 4) {
                count++;
                x[i]=5;
            }
        }
        system.out.println("...."+count);
    } //main()
} //anArray