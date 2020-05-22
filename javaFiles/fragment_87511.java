public static void main(String[] args) {

         Scanner kb = new Scanner(System.in);
         System.out.println("Enter Player A value");

         String A = kb.nextLine();
         calsi(A); 

         System.out.println("Enter Player B value");
         String B = kb.nextLine();
         calsi(B); 
    }

    public static void calsi(String cmdVal){

        if (cmdVal.length()>0) { 
            String firstletter=cmdVal.substring(0,1);
            System.err.println(firstletter+":"+cmdVal.length());
        }else{
            System.err.println("No input has given"); 
        }
    }