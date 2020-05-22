int[] odds = new int[22];
int index = 0;

for (int number = -6; number <= 38; number++) {
    if(Math.abs(number) % 2 == 1) {
        odds[index] = number;
        index++;
    }
}