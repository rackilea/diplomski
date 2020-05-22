void peek() {
    //This was the change - you can peek as long as the stack
    // is NOT empty.
    if (!isEmpty())
        System.out.println(array[top]);
    else
        System.out.println("Stack is empty");

}