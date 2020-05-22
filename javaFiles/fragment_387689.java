public static String chars (String x){
    int len = x.length();

    String charOccurs = "";

    int count = 0;
    int i = 0;
    while (i < len) {
        char c = x.charAt(i);
        count = 1;

        for (int j = i + 1; j < len; j++) {
            if (c == x.charAt(j)) {
                count++;
            } else {
                break;
            }
        }
        charOccurs+= "" + count + c;
        i+=count;
    }

    return charOccurs;
}

public static void main(String[] args) {
    System.out.println(chars("aaaaabbbbcccdde"));
}