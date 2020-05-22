public void setLength(int length) {
    this.length = length;
    int[] newArray = new int[length];
    int backupSize = a.length > this.length? this.length : a.length;
    for (int i = 0; i < backupSize; i++) {
        newArray[i] = a[i];
    }
    a = newArray;
}