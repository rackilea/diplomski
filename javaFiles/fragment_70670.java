public class ProceduralProgramming {

       public static void main(String[] args) {
          fact("Initial fact call : ", 3);
       }
       public static void fact(String note, int n) {
          System.out.println("Entered Fact - " + note + n);
          if (n >= 1) {
             fact("First fact call : ", n - 1);
             System.out.println("returned from first fact call");
             fact2("Fact2 call : ", n);
             System.out.println("returned from fact2 call");
             fact("Second fact call : ", n - 1);
             System.out.println("returned from second fact call");
          }
       }
       public static void fact2(String note, int n) {
          System.out.println(note + n);
       }
    }