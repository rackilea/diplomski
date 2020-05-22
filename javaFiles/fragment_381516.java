public class systemSetInExample {

public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter input:  ");
            String st=br.readLine();                 // takes input from console
            System.out.println("Entered:  "+st);    

            System.setIn(new FileInputStream("test.txt"));
            br=new BufferedReader(new InputStreamReader(System.in));
            st=br.readLine();                       // takes input from file- "test.txt" 
            System.out.println("Read from file:  "+st); 

    } catch (Exception e) {         
        e.printStackTrace();
    }
}