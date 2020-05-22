int vcount = 0;
for (int val : array) {
    if (x == val) {
        vcount++;
        if (vcount >= count) return true;
    }
}
return false;