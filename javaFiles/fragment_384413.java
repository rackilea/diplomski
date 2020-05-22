int[] hand = {2,3,2,3,2,9,5,5,5,5,5,5,5};
boolean[] hasPair = new boolean[10];
for(int i = 0; i <= hand.length - 2 ; i++) {
    for(int j= i + 1; j <= hand.length - 1; j++) {
        if (hand[j] == hand[i]) {
            hasPair[hand[j]] = true;
        }
    }
}
int count = 0;
for (boolean b : hasPair) {
    if (b) {
        count += 1;
    }
}
System.out.print(count);