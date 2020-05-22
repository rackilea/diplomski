@Override
public int compareTo(Card o) {
    int comparisonOutcome = ((Integer)o.getValue()).compareTo((Integer)this.getValue());
    if(comparisonOutcome == 1 || comparisonOutcome == -1){
        return comparisonOutcome;
    else{ 
        // here values are equal, we can compare by card suit
        // return -1, 1 or 0        
}