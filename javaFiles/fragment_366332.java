public void push(T element)
{

    if (top+1==DEFAULT_CAPACITY){
        DropOut();
        //top=top-1;
        pop();
        stack[top]=element;
    } else {
        top++;
        stack[top] = element;
    }
}