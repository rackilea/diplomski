public static int[] reverseArrayWithStack(int[] arrayToReverse)
{
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i < arrayToReverse.length; i++)
        stack.push(arrayToReverse[i]);

    for(int j = 0; j < arrayToReverse.length; j++)
        arrayToReverse[j] = stack.pop();

    return arrayToReverse;
}