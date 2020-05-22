int max = list.size(); // Note change here

while(max > min) {
    int mid = min + ((max - min) / 2);
    if (list.get(mid) == key) {
        return mid;
    } else if (list.get(mid) < key) {
        min = mid +1 ;
    } else {
        max = mid; // Note change here
    }
}