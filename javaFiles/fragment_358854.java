for(int i = 0; i < elementCount; i++){
    if(x.equals(current.data)){
         result = i;
         return result;
    }
    current = current.next; // increment current pointer so that it 
                            // points to the next node in the list
}