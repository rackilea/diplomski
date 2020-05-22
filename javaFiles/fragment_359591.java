int num = 12300321;
int numCopy = num;
int reverseNumInt = 0;

while(numCopy != 0) {
    reverseNumInt = reverseNumInt * 10 + numCopy % 10;
    numCopy /= 10;
}
if(reverseNumInt == num) {
    System.out.println(num + " is a Palindrome!");
}
else {
    System.out.println(num + " is not a Palindrome!");
}