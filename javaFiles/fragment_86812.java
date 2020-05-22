public static void main(String[] args) throws IOException {
    String str = "Reverse me";
    StringBuilder printStr = new StringBuilder();
    printStr.setLength(str.length());

    for(int i =0; i<str.length()/2;i++){
        char left = str.charAt(i);
        final int fromRight = str.length() - i - 1;
        printStr.insert(i, str.charAt(fromRight));
        printStr.insert(fromRight, left);
    }
}