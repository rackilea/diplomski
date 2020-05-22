int doit(int i_incr, int j_incr) {
    int cornerIncrement = 0;
    for (int i=row+i_incr, j=col+j_incr; i>=0 && j>=0; i+=i_incr, j+=j_incr) {
        if (b[i][j]==charAtPosition) {
            cornerIncrement++;
        } else {
            break;
        }
    }
    return cornerIncrement;
}