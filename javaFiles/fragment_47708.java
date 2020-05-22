public class Exam {
        private static void div(int i, int j) throws ArithmeticException {
           System.out.println(i / j);
        }
        public static void main(String[] args) throws Exception {
           div(5, 0);
        }
    }