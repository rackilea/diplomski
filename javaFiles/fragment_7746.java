public int m7() {
    int count = 0; // HERE
    for (int i = 0; i < rank.length; i++) {
        if (rank[i] == n) {
            break;
        }
        count++;
    }
    return count;
}