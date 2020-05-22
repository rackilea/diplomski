if(count % 2 == 0){
    pi = pi + (1 / (1 + (2.0 * count)));        // first to run. starts at pi + 1 and every other loop adds 1/(1+2n)
}

else{
    pi = pi - (1 / (1 + (2.0 * count)));        // first to run. starts at pi - 1/3 and every other loop subtracts 1/(1+2n)
}