public static void main(String[] args) {
    String s="ab34yuj789km2";
    int total = 0;
    for(String numString : s.split("[^0-9]+")) {
        if(!numString.isEmpty()) {
            total += Integer.parseInt(numString);
        }
    }
    // Print the result
    System.out.println("Total = " + total);
}