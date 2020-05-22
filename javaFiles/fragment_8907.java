import java.util.Stack;

public String getFilteredPageContents() {
    String str = getUnfilteredPageContents();
    StringBuilder() temp = new StringBuilder();

    // The closing character for each thing that we're inside
    Stack<Character> expectedClosing = new Stack<Character>();

    for(int i = 0; i<str.length(); i++) {
        char c = str.charAt(i);
        if(c == '<')
            expectedClosing.push('>');
        else if(c == '&')
            expectedClosing.push(';');

        // Is the current character going to close something?
        else if(!expectedClosing.empty() && c == expectedClosing.peek())
            expectedClosing.pop();

        else {
            // Only add to output if not currently inside something
            if(expectedClosing.empty())
                temp.append(c);
        }
    }
    return temp.toString();
}