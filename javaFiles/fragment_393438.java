public static void main(String[] args) {
        int dec = 31388 ;
        StringBuilder hexString = new StringBuilder();

        while (dec != 0){
            int hexDigit = dec%16; // obtain this remainder
            dec /= 16; //update dec

            if (hexDigit < 10) hexString.insert(0, hexDigit);
            else {
                switch (hexDigit) {
                    case 10 :
                        hexString.insert(0, "A");
                        break;
                    case 11 :
                        hexString.insert(0, "B");
                        break;
                    case 12 :
                        hexString.insert(0, "C");
                        break;
                    case 13 :
                        hexString.insert(0, "D");
                        break;
                    case 14 :
                        hexString.insert(0, "E");
                        break;
                    case 15 :
                        hexString.insert(0, "F");
                        break;
                    default: break;
            }
        }
    } // while
    System.out.println(hexString);
}