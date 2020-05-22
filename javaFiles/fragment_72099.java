/**
 * @author Amir
 * Converts from infix to postfix
 */

import java.io.*;

public class InfixToPostfix {
    private ObjectStack realStack;
    private EvalPostFix eval;
    //private SuperOutput so;
    private PrintWriter pw;

/**
 * constructor
 * @param pw 
 */ 
public InfixToPostfix(PrintWriter pw) {
    realStack = new ObjectStack();
    //eval = new EvalPostFix(); 
    this.pw = pw;   
    }

/**
 * method takes each expression from infix.txt and stores them in a string array
 * @param none
 * @return none
 */
public void getInfix() {

//declare new filestream    
FileInputStream in = null;
try {
    in = new FileInputStream("infix.txt");
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
//declare a reader
BufferedReader br = new BufferedReader(new InputStreamReader(in));

//declare string array to store elements in
String[] list = new String[10];

try {
    do {
        for (int n = 0; n < list.length; n++){
            try {
                list[n] = br.readLine();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }       
         for (int i = 0; i < list.length; i++) {
            splitArray(list[i]);
         }
    }
    while (br.readLine() != null);
}

catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}
try {
    in.close();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
//    //System.out.println(Arrays.toString(list));
    //splitArray(Arrays.toString(list));
}

/**
 * Method that splits each line by the spaces
 * @param entries
 */
public void splitArray(String entries) {

    String delims = "[ ]+";
    String[] tokens = entries.split(delims);
//      for (int i = 0; i < tokens.length; i++)
//          System.out.println(tokens[i]);
    convertToPostfix(tokens);
}

/**
 * method that converts from infix to postfix
 * @param tokens
 */
public void convertToPostfix(String[] tokens) {
    StringBuffer br = new StringBuffer();

    for (int n = 0; n < tokens.length; n++) {
        char element = tokens[n].charAt(0);
        if (element <= '9' && element >= '0') {
            br.append(element);
        }
        else if (element == '^' || element == '/' || element == '*' || element == '+' || element == '-' || element == '(') {
            while (!realStack.isEmpty() && (priorityVal(element) <= priorityVal((Character) realStack.top())) && (element !='('))
                br.append(realStack.pop());
            realStack.push(element);

        }
        else if (element == ')') {
            while ((!(realStack.top().equals('('))))
                br.append(realStack.pop());
            realStack.pop();

        }
    }
    while (!realStack.isEmpty())
        br.append(realStack.pop());


    System.out.println(br.toString());
    pw.println(br.toString());

    //eval.evaluate(br.toString());

}

/**
 * method that assigns priority value to each operator
 * @param operator
 * @return priority value
 */
private int priorityVal(char operator) {
    switch (operator) {
    case '^': return 3;
    case '/': 
    case '*': return 2;
    case '+': 
    case '-': return 1;
    default : return 0;
    }
}   

}