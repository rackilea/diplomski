for (int i = 0; i < arr.length; i++){
    if (x < arr[i]) {
        arr2[i] -= z;
        x -= z;
        if (x <= 0) {
            break;
        }
        // Continue with smaller x (assuming z > 0) for rest of arr.
    }
}