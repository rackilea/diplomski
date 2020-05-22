public static long bTol(byte[] b_arr) {
    long res = 0;
    for (int i = 0; i < b_arr.length; i++) {
        res += (long)(b_arr[i] & 0xFF) << ((b_arr.length - 1 - i) * 8);
    }
    return res;
}