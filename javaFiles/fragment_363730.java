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
        int i;
        for( i=0;i<fullName.length();i++){
           if (fullName.charAt(i)==' '){
               break;
           }
        }

        firstName=fullName.substring(0,i+1);
        lastName=fullName.substring(i+1);
        System.out.println(firstName+"' "+lastName);   
    }
}