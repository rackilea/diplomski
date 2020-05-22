if (acctype == 1) {
    // For these if statements, acctype is 1 so we don't need to check that again
    if(currentbalance >= (minbalance+5000)){
        newaccbalance = ((currentbalance*.05)*(1/12));
    }
    else if (currentbalance >= minbalance) {
        //  && currentbalance <  (minbalance+5000) will be true because the above if-statement is **not** true
        newaccbalance = ((currentbalance*.03)*(1/12)); 
    }
    else { 
        // if (acctype == 1 && currentbalance < minbalance) would always be true here
        newaccbalance = (currentbalance-25);
    }
}
else if (acctype == 2){
     // Savings
     if (currentbalance >= minbalance) {
          newaccbalance = ((currentbalance*.04)*(1/12));
     }
     else { // currentbalance < minbalance) is always true here
          newaccbalance = (currentbalance - 10);
     }
}
else {
     // acctype is neither 1 or 2, what should we do now? RuntimeError, Catastrophic failure, the monsters are coming! We're screwed!
}