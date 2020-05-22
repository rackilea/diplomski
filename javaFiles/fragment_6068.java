char alphabet[] = {'a','b','c', ...}; // Set of chars that will be used in table
char table[][] = new char[26][26]; // Size must be same as size of alphabet

private void prepareTable() {
    for (int x = 0; x < table.length; x++) {
        for (int y = 0; y < table[x].length; y++) {
            // Copy alphabet to row in table but offset it each row by 1
            table[x][y] = alphabet[(x + y) % alphabet.length];
        }
    }
    // Now table looks like this:
    // 'a' 'b' 'c'
    // 'b' 'c' 'a'
    // 'c' 'a' 'b
}