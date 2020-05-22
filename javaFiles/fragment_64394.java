public class Question {




    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String s = "abaqueru";

       calculate(s);
        // TODO code application logic here
    }

    public static void calculate(String s){
         String result;

            for(int i = 0; i < s.length(); i++)
            {
               char c = s.charAt(i);

               char temp;
               temp=c;
               for(int j = i+1; j < s.length(); j++)
                    {

                       char x = s.charAt(j);
                       if(temp==x){

                          s=s.replaceAll(""+temp, "");

                           break;
                         //  calculate(s);
                       }



                    }


            }

            System.out.println(s);

    }

}