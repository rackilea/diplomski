import java.io.*; 

    public class doscmd 
    { 
        public static void main(String args[]) 
        { 
            try 
            { 
                Process p=Runtime.getRuntime().exec("cmd /c dir"); 
                p.waitFor(); 
                BufferedReader reader=new BufferedReader(
                    new InputStreamReader(p.getInputStream())
                ); 
                String line; 
                while((line = reader.readLine()) != null) 
                { 
                    System.out.println(line);
                } 

            }
            catch(IOException e1) {e1.printStackTrace();} 
            catch(InterruptedException e2) {e2.printStackTrace();} 

            System.out.println("Done"); 
        } 
    }