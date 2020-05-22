public void pop()
{

    if(isEmpty()){

        return;
    }

    if (top>=0){

        stackArray[top] = stackArray[top--];
        pop();
    }


}