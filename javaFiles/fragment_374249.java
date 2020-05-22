int num = ...; // inputed from user
List<Integer> digits = new LinkedList<>();
int sum = 0;

// Extract the digits and the sum
while (num != 0) {
    int digit = num % 10;
    digits.add (digit);
    sum += digit;
    num /= 10;
}

// Print backwards:
System.out.print ("The digits are: ");
for (int i = digits.size() - 1; i >= 0; --i) {
    System.out.print (digits.get(i) + " ");
}
System.out.println();
System.out.println("Their sum is: " + sum);