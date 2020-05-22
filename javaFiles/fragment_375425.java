for(int i = 0; i < firstbuyers.length; i++) {
    // ... refer to current firstbuyer as firstbuyers[i]
    if((firstbuyer[i] - open) < 2) {
        lessthan2 = lessthan2 + 1;
    }
}