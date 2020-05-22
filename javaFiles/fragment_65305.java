public void solve() {
    combineTo(i, 0, 1, 2); // combines 2 stacks to the right
    hanoi(2*i, 2, 0, 1); // moves big stack to the left
    splitTower(2*i, 0, 1, 2); // splits tower up again
}

private void splitTower( int i, int from, int to, int temp) {
    if (i == 0) return;
    else{
        hanoi(i-1, from, to, temp);
        splitTower( i-1, to, from, temp );
    }
}


private void hanoi( int i, int from, int to, int temp) {
    if (i == 0) return;
    else{
        hanoi( i-1, from, temp, to );
        moveDisk(from, to);
        hanoi( i-1, temp, to, from );
    }
}