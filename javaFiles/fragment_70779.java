if (value > firstMax) {
    secondMax = firstMax;
    firstMax = value;
} 
else if (value > secondMax) {
    secondMax = value;
}

if (value < firstMin) {
    secondMin = firstMin; 
    firstMin = value;
}
else if (value < secondMin) {
    secondMin = value;
}