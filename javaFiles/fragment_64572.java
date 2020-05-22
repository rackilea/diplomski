int unSelectedSum = 0;

for(int i = 1; i<creditCard.length(); i=i+2) {

    //first we will take every even-placed digit.
    int evenDigit = Character.getNumericValue(creditCard.charAt(i));

    //next, we will multiply it by 2
    evenDigit = evenDigit*2;

    //And finally, we will add the digits to unselectedSum
    if(num/10 == 0) {
        unselectedSum = unselectedSum + evenDigit;
    }
    else {
        unselectedSum = unselectedSum + evenDigit/10 + evenDigit%10;
    }        
}