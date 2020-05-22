while (value > 0) {

    if ((value%10)==0) {
       zeroCount++;
    }
    else if (value%2==0) { //As per comment below...
       evenCount++;
    }
    else { 
       oddCount++;
    }

    value /= 10;
}