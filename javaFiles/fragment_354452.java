while (low < high) {        
    mid = (low + high) / 2;
    System.out.print(i + " ");
    if (array[mid] < key) {
        low = mid + 1;
    } else if (array[mid] > key) {
        high = mid;
    }
    else {
        return mid;
    }
    i++;
}