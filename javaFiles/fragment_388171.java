int pos = 0; // keeps track of position in newSequence.values

for (int i=0; i < this.values.length; i++) {
    if (this.values[i] != n) {
        newSequence.values[pos] = this.values[i];
        pos++;  
    }
}