public String toHexString(byte[] arr) {
    if (arr == null || arr.length == 0) {
        return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(Integer.toHexString(arr[0] & 0xff));
    for (int i = 1; i < arr.length; i++) {
        sb.append(' ').append(Integer.toHexString(arr[i] & 0xff));
    }
    return sb.toString();
}