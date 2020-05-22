private Stack<Integer> toIntegerStack(String n){
    Stack<Integer> stack = new Stack<Integer>();
    for(char c: n.toCharArray())
      stack.push(c-48);//ASCII
    return stack;
 }//toStack(String)