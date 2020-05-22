public class Test {

    public static void main(String[] args) {    
        String str ="This is a test";
        for(int i=0;i <str.length();i++){
            if((str.charAt(i) == 'a') || 
                (str.charAt(i) == 'e')  ||
                (str.charAt(i) == 'i') || 
                (str.charAt(i) == 'o') ||
                (str.charAt(i) == 'u')) {
                System.out.println(" The String contains " + str.charAt(i));
            }
        }
    }
    }