public static void main(String[] args) throws IOException {
    int[] decContent = new int[] {1,0,5,0,0,0};
    int val = decContent[ 2 ] | (decContent[ 3 ] << 8)
              | (decContent[ 4 ] << 16) | (decContent[ 5 ] << 24);
    System.out.println(val);
}