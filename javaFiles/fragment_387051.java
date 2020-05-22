for(int outputIndex = 0; outputIndex < output.length; outputIndex++) {
    if (aIndex < a.length
            && (bIndex >= b.length || a[aIndex] <= b[bIndex])
            && (cIndex >= c.length || a[aIndex] <= c[cIndex])) {
        output[outputIndex] = a[aIndex];
        aIndex++;
    } else if (bIndex < b.length
            && (aIndex >= a.length || b[bIndex] <= a[aIndex])
            && (cIndex >= c.length || b[bIndex] <= c[cIndex])) {
        output[outputIndex] = b[bIndex];
        bIndex++;
    } else {
        output[outputIndex] =  c[cIndex];
        cIndex++;
    }
}