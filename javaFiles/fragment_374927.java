State currState=startState;
while(currState!=null && input.hasNextChar()){//you can also end directly when final state is reached
    char next = input.nextChar();//get next character
    currState = currState.next(next);
}

if(currState!=null && currState.isFinal()){
    // reached final state
}else{
    // to bad didn't match
}