public static void main(String[] args) {
    byte[] arr = new byte[500];
    int cnt = 0;
    String[] str = {"aaa","bbb","ccc"};
    for (String label : str){
        for (char c : label.toCharArray()) {
            arr[cnt++] = (byte) c;
        }
    }
    System.out.println(Arrays.toString(arr));
}