public class arraycheck {





     public static void main(String args[]) {
            int a[] = { 41, -2, 1, 2, -88, 55, -4 };
            int b[] = new int[a.length];

            for (int i = 0; i < a.length; i++) {

                if(a[i] < 0)
                {

                    System.out.println(a[i]);
                    b[i] = a[i];;
                }

            }
        }