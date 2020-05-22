public class ScannerRunner implements Runnable {
         private Scanner sc;
         private ScannerRunner() {/* no instantiation without parameters*/}
         public ScannerRunner(Scanner sc) {
            this.sc = sc;
         }
         @Override
         public void run() {     
            System.out.println("Enter The Correct Number ! ");
            int question = sc.nextInt(); 

            while (question!=1){
               System.out.println("please try again ! ");
               question = sc.nextInt(); 
            }
            System.out.println("Success");
        }
     }