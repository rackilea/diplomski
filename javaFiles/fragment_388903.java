public static String arabicToRoman(int arabic) {
    String a = ""; // note this String declaration at the start of the method

    while (arabic >= 1000) {
        a += "M";
        arabic -= 1000;
    }
    while (arabic >= 900) {
        a += "CM";
        arabic -= 900;
    }
    while (arabic >= 500) {
        a += "D";
        arabic -= 500;
    }
    while (arabic >= 400) {
        a += "CD";
        arabic -= 400;
    }
    while (arabic >= 100) {
        a += "C";
        arabic -= 100;
    }
    while (arabic >= 90) {
        a += "XC";
        arabic -= 90;
    }
    while (arabic >= 50) {
        a += "L";
        arabic -= 50;
    }
    while (arabic >= 40) {
        a += "XL";
        arabic -= 40;
    }
    while (arabic >= 10) {
        a += "X";
        arabic -= 10;
    }
    while (arabic >= 9) {
        a += "IX";
        arabic -= 10;
    }
    while (arabic >= 5) {
        a += "V";
        arabic -= 5;
    }
    while (arabic >= 4) {
        a += "IV";
        arabic -= 4;
    }
    while (arabic >= 1) {
        a += "I";
        arabic -= 1;
    }
    return a;
}