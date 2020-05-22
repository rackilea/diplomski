double lowerBound = smallestElement();
for (int i = 0; i < data.length; i++) {
    for (int j = 0; j < divisions; j++) {
        if (data[i] <= (lowerBound + (j+1) * segment)) {
            range[j] += 1;
            continue;
        }
    }
}