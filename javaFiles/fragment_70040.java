public class CheckPalindrome {

static int counter;

/** Decides whether the parentheses, brackets, and braces
in a string occur in left/right pairs.
@param expression a string to be checked
@return true if the delimiters are paired correctly */
public static boolean checkBalance(String expression)
{
    counter = 0;
     StackInterface<Character> temporaryStack = new LinkedStack<Character>();
     StackInterface<Character> reverseStack = new LinkedStack<Character>();
     StackInterface<Character> originalStack = new LinkedStack<Character>();

     boolean isBalanced = true;

    int characterCount = expression.length();

    int index = 0;
    char nextCharacter = ' ';


    for (;(index < characterCount); index++)
    {
        nextCharacter = expression.charAt(index);
        switch (nextCharacter)
        {
        case '.': case '?': case '!': case '\'': case ' ': case ',':
            break;
        default: 
        {
            {
                reverseStack.push(nextCharacter);
                temporaryStack.push(nextCharacter);

            }

            break;
        }
        } // end switch


} // end for

while(!temporaryStack.isEmpty()){
    originalStack.push(temporaryStack.pop());
}

while(!originalStack.isEmpty()){
    char letter1 = Character.toLowerCase(originalStack.pop());
    char letter2 = Character.toLowerCase(reverseStack.pop());
    isBalanced = isPaired(letter1, letter2);
    if(isBalanced == false){
        counter++;
    }
}


    return isBalanced;
} // end checkBalance

// Returns true if the given characters, open and close, form a pair
// of parentheses, brackets, or braces.
private static boolean isPaired(char open, char close)
{
    return (open == close);
} // end isPaired

public static int counter(){
    return counter;
}


}