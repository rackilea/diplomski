int pop()
{
    //declare local variable
    int temp;
    //if statement to check if stack is not empty
    if(!isEmpty())
    {
        temp = array[top]; //note the change here
        top--;
        length--;
    }
    else
        System.out.println("No more items in Stack.");

    return temp; //note the change here
}