Scanner sc = new Scanner(System.in);
String sentence = sc.nextLine();
char[] a = sentence.toCharArray();

boolean notPalindrome = false;
for (int i = 0, j = a.length - 1; i < j; i++, j--) {
    if (a[i] != a[j]) {
        notPalindrome = true;
        break;
    }
}
if (notPalindrome) {
    System.out.println("String is not Palindrome");
} else {
    System.out.println("String is Palindrome"); 
}