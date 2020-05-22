void shuffleColumns() {
    int items = table[0].length;

    while (items > 0) {
        int index = r.nextInt(items);

        // Swap chars in each row
        for (int i = 0; i < table.length; i++) {
            char tmp = table[i][index];
            table[i][index] = table[i][items - 1];
            table[i][items - 1] = tmp;
        }

        items --;
    }
}