int[] copyOfRange (int[] src, int start, int end) {
    int len = end - start;
    int[] dest = new int[len];
    Array.Copy(src, start, dest, 0, len);
    return dest;
}