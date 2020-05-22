boolean foundMatch = false;
while(!foundMatch) {
    foundMatch = Y.equals(X);
    if(foundMatch) {
        break;
    }
    else {
        Y = Y.useSplitToRemoveLastPart();
        if(Y.equals("")) {
            break;
        }
    }
}