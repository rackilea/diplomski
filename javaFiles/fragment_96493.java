import java.util.*;

public class onetimepad {
    public static void main(String args[]) {
        HashMap <String , Integer>hm  = new HashMap <String , Integer> (); 
        hm.put("e", 0); //or use hm.put("e", 0b000);
        hm.put("h", 1); //or use hm.put("e", 0b001);
        hm.put("i", 2);
        hm.put("k", 3);
        hm.put("l", 4);
        hm.put("r", 5);
        hm.put("s", 6);
        hm.put("t", 7);

        String[] key = { "t" ,"r" , "s" , "r","t","l","e", "r","s","e"};
        //key = t r s r t l e r s e
        String[] input = {"h","e","i" ,"l","h","i","t","l","e","r"};
        int[] cipher = new int[10]; 
        System.out.println("Binary form of text is ....");

        String temp = "000", binary;
        for( String s : input ) {
            binary = Integer.toString(hm.get(s), 2);
            System.out.print(temp.substring(0, 3-binary.length()) + binary +" ");
        }
    }   
}