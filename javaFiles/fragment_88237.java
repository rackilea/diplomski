int sum_start = 0, sum_end = 0, start = 0, end = 0;
// In the for loop
if (X[i] > sum + X[i]) {
    sum = X[i];
    sum_start = i;
    sum_end = i;
} else {
    ++sum_end;
}
if (sum > max) {
    start = sum_start;
    end = sum_end;
    max = sum;
}