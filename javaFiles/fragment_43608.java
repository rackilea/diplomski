if (arr != null) {
    for (int i = arr.length - 1; i >= 0; i--){
        if (target == arr[i]) {
            return i;
        }
    }
}
return -1;