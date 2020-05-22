public class HelloWorld{

     public static void main(String []args){
        int counter=59;
        for(int x=0; x<=counter; x++)
        {   
            int quotient, remainder;
            String result="";
            quotient=x;

            while (quotient >= 0)
            {
                remainder = quotient % 26;
                result = (char)(remainder + 65) + result;
                quotient = (int)Math.floor(quotient/26) - 1;
            }
            System.out.print(result+ " ");
        }
     }
}