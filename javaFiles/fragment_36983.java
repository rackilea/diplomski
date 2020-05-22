import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test   {
    public static void main(String[]args){
        String str = new String("abcba");
        String str2 = new String("abcde");
        System.out.println(isPal(str));
        System.out.println(isPal(str2));
    }
    public static boolean isPal(String str)
    {
        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<String>();

        String s = new String();
        for (int i = 0; i < str.length( ); i++) {
            s = "" + str.charAt(i);
            System.out.println(s);
            queue.add(s);
            stack.push(s);
        }
        // start to compare
        while (!queue.isEmpty( )) {
            if (!queue.remove().equals(stack.pop( )))
                return false;
        }
        // finished w/ empty queue (and empty stack)
        return true;
    }
}