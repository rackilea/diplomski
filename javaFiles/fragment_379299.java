int low = 0;
int high = array.length - 1;
int mid = (high + low) / 2;  // priming read

while (array[mid] != x && low <= high) {
    if (array[mid] > x)
        high = mid - 1;
    else   // (array[mid] < x)
        low = mid + 1;
    mid = (high - mid) / 2;
}