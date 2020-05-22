public static void main(String[] args) {
    int dec = 31388;
    String answer = "";

    while (dec != 0){
        int hexDigit = dec%16; // obtain this remainder
        dec /= 16; //update dec

        if (hexDigit < 10) {
            answer = hexDigit + answer;
        }
        else {
            if (hexDigit == 10) {
                answer = "A" + answer;
            } else if (hexDigit == 11) {
                answer = "B" + answer;
            } else if (hexDigit == 12) {
                answer = "C" + answer;
            } else if (hexDigit == 13) {
                answer = "D" + answer;
            } else if (hexDigit == 14) {
                answer = "E" + answer;
            } else if (hexDigit == 15) {
                answer = "F" + answer;
            }
        }
    } // while
    System.out.println(answer);
}