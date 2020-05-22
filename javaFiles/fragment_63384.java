public void code() {
    int x = message.length() - 1;
    boolean enter = true;
    g = "";
    for (int i = 0; i <= x; i++) {
        int j = message.charAt(i);
            if ((j >= 32 && j <= 64) || (j >= 91 && j <= 96)
        || (j >= 123 && j <= 127)) {
            }

        else if ((j >= 65 && j <= 90)) {
            j = j + 2;
            if (j > 90) {
                j = (j - 90) + 64;
                }
        } else if (j >= 97 && j <= 122) {
            j = j + 2;
            if (j > 122) {
                j = (j - 122) + 96;
            }
        }
        if(enter == true){
            System.out.println();
            System.out.print("  ");
            enter = false;
        }
        y = (char) (j);
        g = g + y;
    }
    message = g;
}