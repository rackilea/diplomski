/**
* Simple Pop function
*/
private int popStack(){
    if(top >= 0){
        return myStack[top--];
    }else{
        throw new IndexOutOfBoundsException("The stack is empty");
    }
}