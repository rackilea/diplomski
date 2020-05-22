import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1 {       
        final static int    a=1,b=2,c=3,d=4,e=5,f=8,g=3,h=5,i=1,j=1,k=2,l=3,m=4,n=5,o=7,p=8,q=1,r=2,s=3,t=4,u=6,v=6,w=6,x=5,y=1,z=7;

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String userInput = in.readLine();
            String input;
            int adder = 0;
            System.out.println(" userInput " + userInput);
            for (int i = 0; i < userInput.length(); i++){
                input = userInput.charAt(i) + "";
                System.out.println(" input " + input);
                if (input.equals("k"))
                    adder += k; 
                if (input.equals("a"))
                    adder += a;;
                if (input.equals("m"))
                    adder += m;;
                if (input.equals("r"))
                    adder += r;
                if (input.equals("b"))
                    adder += b;
                if (input.equals("n"))
                    adder += n;
            }                    
            System.out.println(" adder " + adder);  
        }
}