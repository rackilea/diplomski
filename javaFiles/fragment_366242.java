int number = 0;
int theNumbers() {

number = 10; // sample number
return number;
}

void mousePressed() {
number = theNumbers();
long numberLong = aLongNumber + (number * aLongNumber);
}