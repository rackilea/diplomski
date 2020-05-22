public class OpCond {
          public static void main(String [] args) {
             int n = 10, p = 5, q = 10;
             //n = p = q = 5;
             n = 5;
             p =5;
             q=5;
             //n += p += q;
             p = p + q //so p = 10
             n = n + p //so n = 15

             //disp : A : n = 15 p = 10 q = 5
             System.out.println("A : n = " + n + " p = " + p + " q = " + q);

             //q = n < p ? n++ : p++;
             if (n<p) { //false here
                 q = n; 
                 n = n + 1; 
             }else{
                 q = p //q = 10
                 p = p + 1; // p = 11
             }

             //disp : B : n = 15 p = 11 q = 10
             System.out.println("B : n = " + n + " p = " + p + " q = " + q);


             //q = n > p ? n++ : p++;
             if (n>p) { //true here
                 q = n; //q=15
                 n = n + 1; // n = 16
             }else{
                 q = p
                 p = p + 1;
             }

             //disp : C : n = 16 p = 11 q = 15
             System.out.println("C : n = " + n + " p = " + p + " q = " + q);


}