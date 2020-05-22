Field largestField = Field.INT_HX;
int largestValue = intHx;
if(intEx > largestValue) {
    largestField = Field.INT_EX;
    largestValue = intEx;
}
if(intRx > largestValue) {
    largestField = Field.INT_RX;
    largestValue = intRx;
}
if(intMx > largestValue) {
    largestField = Field.INT_MX;
    largestValue = intMx;
}
if(intIx > largestValue) {
    largestValue = intIx;
}
switch(largestField) {
    case INT_HX:
        // call the intHx related method
    break;
    case INT_EX:
        // call the intEx related method
    break;
    case INT_RX:
        // call the intRx related method
    break;
    case INT_MX:
        // call the intMx related method
    break;
    case INT_IX:
        // call the intIx related method
    break;
}