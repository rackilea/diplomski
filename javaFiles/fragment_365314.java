public static void main(String[] args) {
    String password = "zebra";
    char [] passArr = password.toCharArray();

    String brutePass = "";
    char[] alphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p','q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    boolean solved = false;
   StringBuilder forcedPass = new StringBuilder(brutePass); // Initialize StringBuilder outside.
    while (solved != true) {
         for (int j = 0; j < passArr.length; j++) { //Moved for loop outside.
        for (int i = 0; i < alphabet.length; i++) {

                if (alphabet[i] == passArr[j]) {
                    forcedPass.append(passArr[j]); // Used append instead of insert
                    System.out.println(forcedPass.toString());
                    solved = true;
                }
            }
        }
    }
}