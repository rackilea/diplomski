import java.util.Random;
import java.util.Stack;

public class StackRecursionSum  {

    private final static int STACK_SIZE = 1000000;
    private final static int RECURRSION_DEPTH = 1000; //limit of the recursion depth 

    public static void main(String[] args) {

        StackRecursionSum r = new StackRecursionSum();

        Stack<Integer> stack = new Stack<>();
        Random rnd = new Random();

        for (int i = 0; i < STACK_SIZE; i++) {
            stack.push(rnd.nextInt(10 - 1));
        }

        int sumForTesting =0;
        for (int i = 0; i < STACK_SIZE; i++) {
             sumForTesting += stack.get(i);
        }

        int stackSum = 0;
        while(! stack.isEmpty()) {

            stackSum += r.sumStack(stack, RECURRSION_DEPTH, 0);
        }

        //output
        System.out.println("Stack sum is = " + stackSum);

        //test 
        if(! stack.isEmpty()) {

            System.out.println("Error: stack is not empty. Recurssion did not end properly");
        }else if (stackSum != sumForTesting){

            System.out.println("Error: wrong test sum. Should be "+ sumForTesting);
        }else {
            System.out.println("************** All ok ");
        }
    }

    private int sumStack(Stack<Integer> stack, int maxNumberOfElementsToSum,  int sum) {

        if ((maxNumberOfElementsToSum > 0) && ! stack.isEmpty()) {

            maxNumberOfElementsToSum --;
            sum += stack.pop(); //remove last element from stack and add to sum

            return sumStack(stack, maxNumberOfElementsToSum , sum);

        } else {

            return sum;
        }
    }
}