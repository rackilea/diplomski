void altCaps(String hi) {
    boolean caps = true;
    for (char ch : hi.toCharArray()) {
        if (ch == ' ') {
            System.out.print(ch);
        } 
        else if (Character.isLetter(ch)) {
            if (caps) System.out.print(Character.toUpperCase(ch));
            else System.out.print(Character.toLowerCase(ch));
            caps = !caps;  // switch between upper and lower every character 
        }