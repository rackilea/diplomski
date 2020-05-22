int c[] = new int[10];
//System.out.println(c.length);
for (int i = 0; i < numbers.length; i++) {
    int aNumber = numbers[i];
    if (aNumber == 0)
        c[0]++;
    else {
        while (aNumber > 0) {
            int aDigit = aNumber % 10;
            System.out.println(aDigit);

            c[aDigit]++;
            System.out.println(c[aDigit]);

            aNumber = aNumber / 10;
        }
    }
}