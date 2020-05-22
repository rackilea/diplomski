class Compare2DArray implements Comparator<int[]> {
  public int compare(int a[], int b[]) {
    for (int i = 0; i < a.length && i < b.length; i++)
      if (a[i] != b[i])
        return a[i] - b[i];
    return a.length - b.length;
  }
}