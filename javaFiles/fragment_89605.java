while(leftIterator.hasNext() && rightIterator.hasNext(){
    int comparisonResult = leftElement.compare(rightElement);
    if (comparisonResult == -1){
        leftElement = leftIterator.next();
    }
    else if (comparisonResult == 1){
        rightElement = rightIterator.next();
    }
    else{
        // found it!
        return true;
    }
}