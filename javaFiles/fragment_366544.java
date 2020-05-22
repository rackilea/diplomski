public static String convert(int n) {
    String roman = "";
    if ((n >= 0) && (n <= 3999)) {
        int thousand = (n / 1000);
        int hundred = (n % 1000) / 100;
        int tens = (n % 100) / 10;
        int units = (n % 10);

        if (thousand >= 1) {
            if (thousand == 1)
                roman += "M";
            else if (thousand == 2)
                roman += "MM";
            else roman += "MMM";
        }

        if (hundred >= 0) {
            if (hundred == 0)
                roman += "";
            else if (hundred == 1)
                roman += "C";
            else if (hundred == 2)
                roman += "CC";
            else if (hundred == 3)
                roman += "CCC";
            else if (hundred == 4)
                roman += "CD";
            else if (hundred == 5)
                roman += "D";
            else if (hundred == 6)
                roman += "DC";
            else if (hundred == 7)
                roman += "DCC";
            else if (hundred == 8)
                roman += "DCCC";
            else
                roman += "CM";
        }

        if (tens >= 0) {
            if (tens == 0)
                roman += "";
            else if (tens == 1)
                roman += "X";
            else if (tens == 2)
                roman += "XX";
            else if (tens == 3)
                roman += "XXX";
            else if (tens == 4)
                roman += "XL";
            else if (tens == 5)
                roman += "L";
            else if (tens == 6)
                roman += "LX";
            else if (tens == 7)
                roman += "LXX";
            else if (tens == 8)
                roman += "LXXX";
            else
                roman += "XC";
        }

        if (units >= 0) {
            if (units == 0)
                roman += "";
            else if (units == 1)
                roman += "I";
            else if (units == 2)
                roman += "II";
            else if (units == 3)
                roman += "III";
            else if (units == 4)
                roman += "IV";
            else if (units == 5)
                roman += "V";
            else if (units == 6)
                roman += "VI";
            else if (units == 7)
                roman += "VII";
            else if (units == 8)
                roman += "VIII";
            else
                roman += "IX";
        }
    } else {
        roman = "Number cannot be converted as it exceeds over 3999";
    }
    return roman;
}