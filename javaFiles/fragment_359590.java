int num = 12300321;
String numString = String.valueOf(num);
String reverseNumString = new StringBuilder(numString).reverse().toString();

if(numString.equals(reverseNumString)) {
    System.out.println(num + " is a Palindrome!");
}
else {
    System.out.println(num + " is not a Palindrome!");
}