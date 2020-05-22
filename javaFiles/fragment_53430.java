public void swapByIndex(int firstIndexValue, int secondIndexValue){
    if(firstIndexValue<0 || secondIndexValue<0 || firstIndexValue>size-1 || secondIndexValue>size-1) {
        throw new ArrayIndexOutOfBoundsException();
    }
    else if(head == tail){ // Case one - only one element in list
        System.out.println("The list only has one element. Nothing to swap. ");
    }
    else{ // Case Two - two or more elements
        //keep a pointer to the next element of head
        Node firstSwapElement = head; //THIS IS THE FIRST ELEMENT!
        Node previousFirstSwapElement = firstSwapElement;
        for(int k=0; k<firstIndexValue; k++){
            previousFirstSwapElement = firstSwapElement; // save the node P is on into 'previ' node
            firstSwapElement = firstSwapElement.nextNodeLink; // P iterates to next node
        }

        Node secondSwapElement = head;
        Node previousSecondSwapElement = secondSwapElement;
        for(int k=0; k<secondIndexValue; k++){
            previousSecondSwapElement = secondSwapElement;
            secondSwapElement = secondSwapElement.nextNodeLink;
        }

        Integer temp = (Integer)secondSwapElement.data;
        secondSwapElement.data = firstSwapElement.data;
        firstSwapElement.data = temp;

    }
}