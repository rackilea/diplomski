Random r = new Random( /* seed */ );
void shuffleRows() {
    int items = table.length;

    while (items > 0) { // While there is something to shuffle
        int index = r.nextInt(items);

        // Simple swap
        char[] tmp = table[index];
        table[index] = table[items - 1];
        table[items - 1] = tmp;

        items --; // Move on to the next
    }
}