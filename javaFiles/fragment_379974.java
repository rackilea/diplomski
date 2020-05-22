import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AlphaCount {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string");
    String str = sc.nextLine();
    Map<Character, Integer> map = new HashMap<Character, Integer>(); 
    char[] chArray = str.toCharArray();
    for(char c : chArray){
        if(map.containsKey(c)){
            map.put(c, map.get(c)+1);
        }
        else{
            map.put(c, 1);
        }
    }
    for (Entry<Character, Integer> entry : map.entrySet())
    {
        System.out.print(entry.getKey() + "" + entry.getValue()+" ");
    }
}

}