while(state[p] == sets[p].length) {
    state[p] = 0;
    p++; 
    if (p == sets.length) return;
    state[p]++;
}