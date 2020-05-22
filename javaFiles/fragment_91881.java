public static Object stack (Object element)
{
    Object top = element;

    int input = 0;
    while (input != 2) {
        input = ... // get user input - 1 for push 2 for pop
        if (input == 1) {
            Object newElement = ... // get input from user
            Object poppedElement = stack (newElement); // push the new element
        } 
    }
    return top; // pop the top of the stack
}