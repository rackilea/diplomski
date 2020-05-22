static void GenerateAllPasswordsWords(String pwd, int pos, int siz) {

    if (pos < siz) {
        if (h.charAt(pos) == '#') { // Dont use i here, you have pos as your current position parameter
            for (String str : names) {
                GenerateAllPasswordsWords(pwd + str, pos + 1, siz);
            }
        }
        if (h.charAt(pos) == '0') {
            for (String str : chars) { // Why do you use i
                GenerateAllPasswordsWords(pwd + str, pos + 1, siz);
            }
        }

    } else {
        System.out.println(pwd);
    }
}