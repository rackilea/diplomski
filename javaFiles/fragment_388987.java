// if there is only one element arr= {1}
    if (low == high) {
        result.min = arr[low];
        result.max = arr[high];
        return result;
    }