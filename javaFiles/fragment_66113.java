marked = new Marked[N];
for(int i = 0; i < N; i++) {
    marked[i] = new Marked<Boolean, Integer>();
    marked[i].bool = false;
    marked[i].comp = 0;
}