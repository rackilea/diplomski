package practice;

/**
 *
 * @author manoj.sharma
 */

public class Test{
public static void main(String [] a){
System.out.println(new Test().isUniqueChars("Hello world"));
}
public boolean isUniqueChars(String str){
    if (str.length() > 256)
        return false;

    boolean[] char_set = new boolean[256];
    for (int i = 0; i< str.length(); i++){
        int val = str.charAt(i);
        if (char_set[val]) {
            return false;
        }
        char_set[val] = true;
    }
    return true;
}
}