import java.util.*;  
    import java.io.File;  

    public class Factors 
    { 
        static String filename;  
     public static void main(String[] args) 
     {
            //scanner initialization, needs to be done in every program that reads from user  
            Scanner input = new Scanner(System.in);  
            int caseIndex=0;  

            //prompts user for filename  
            System.out.println("Please enter the name of the file you would like to read from.");  
            filename = input.nextLine();  
            File file=new File(filename);
            //checks if filename exists  
            if(file.exists())  
                System.out.println(file.getName() + "exists!");  
            else  
                System.out.println("File name does not exist!");  
    }

}