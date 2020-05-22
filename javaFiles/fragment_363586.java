import java.util.*;

class head {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c1 = 0, c2 = 0;
        int i;
        while (n > 0) {
            //check for EOF
            if(!sc.hasNext()) {
                break;
            }
            int l = sc.nextInt();
            String str = sc.next();

            for (i = 0; i < l; i++) {
                char ch = str.charAt(i);
                if (ch == 'i' || ch == 'I')
                    c1++;
                if (ch == 'y' || ch == 'Y')
                    c2++;
            }
            if (c1 > 0)
                System.out.println("INDIAN");
            else if (c2 > 0)
                System.out.println("NOT INDIAN");
            else
                System.out.println("NOT SURE");
            c1 = 0;
            c2 = 0;
            n--;
        }
    }
}