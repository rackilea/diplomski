import java.util.*;

class Main {
    public static void main(String[] args) {
        boolean continue = true;
        while (continue){
            boolean flag = false;
            Scanner key = new Scanner(System.in);
            String s = key.nextLine();
            String upperCaseStr = s.toUpperCase();
            //if (upperCaseStr.trim() == "QUIT"){
            //    continue = false;
            //} -> don't compare Object's values by their references
            continue = "QUIT".equals(s.toUpperCase());
            for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
                if(upperCaseStr.indexOf(alphabet)==-1){
                    flag=true;
                    break;
                }  
            }
            if (flag){
                System.out.print(s + " is not a pangram");
            }
            else
                System.out.println(s + " is a pangram");
        }
    }
}