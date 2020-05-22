public static void main(String[] args) {
    //Creating array
    List<String> al = Arrays.asList("25*ax+c-d/2".split("[\\*+/-]"));

    //Creating a stack 
    Stack<String> STACK = new Stack<String>(); 

    //Adding array to stack 
    for(String str : al)
        STACK.add(str);

    // Displaying the Stack 
    System.out.println("Initial Stack: " + STACK); 
}