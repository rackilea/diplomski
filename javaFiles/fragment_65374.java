int count = 0;
for (Integer number : lottoNumbers) {
    if (count < 5) {
        if (count == 4) {
            System.out.print(number);
        } else {
            System.out.print(number + ", ");
        }
    } else {
        System.out.println("\nPower Ball: " + number);
    }
    count++;
}