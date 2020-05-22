import java.util.Scanner;   

public class namessplit{
    public static void main(String args[]){
        String fullName="";   
        String[] str;   
        String firstName="";  
        String lastName="";  
        Scanner scanner=new Scanner(System.in);   
        System.out.println("Enter the full name:");   
        fullName=scanner.nextLine();    
        System.out.println("The names after split is:");   
        str=fullName.split(" ");
        firstName=str[0];
        lastName=str[1];
        System.out.println(firstName+"' "+lastName);   
    }
}