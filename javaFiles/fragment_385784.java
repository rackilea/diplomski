public class StringInSwitchCase{ 
    public static void main(String[] args) { 
        String mode = args[0]; switch (mode) { 
            case "ACTIVE": System.out.println("Application is running on Active mode"); 
                break; 
            case "PASSIVE": System.out.println("Application is running on Passive mode"); 
                break; 
           case "SAFE": System.out.println("Application is running on Safe mode"); 
        } } }