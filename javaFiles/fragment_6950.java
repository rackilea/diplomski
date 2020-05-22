int n = 2;
Creature[][] f = new Creature[generations][];
for(int i = 0; i < generations; i++){
    f[i] = new Creature[n];
    n = 2*n;
}