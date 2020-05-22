for (int k = p - 1; k < r; k++) {
    if (arrLeft[i] <= arrRight[j]) {
        arrNums[k] = arrLeft[i];
        i++;
    } else {
        arrNums[k] = arrRight[j];
        j++;
    }
}