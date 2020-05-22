public void removeDups() {
    if (nElements < 1) {
        System.out.println("Empty Array");
    } else {
        for (int i = 0; i < nElements; i++) {
            for (int j = i + 1; j < nElements; j++) {
                 if (arr[i] == arr[j]) {
                    System.arraycopy(arr, i + 1, arr, i, nElements - (i + 1));
                    nElements--;
                    i--;
                    break;
                }
            }
        }
        for (i = 0; i < nElements; i++) {
            System.out.println(arr[i]);
        }
    }
}