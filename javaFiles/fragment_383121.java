public static int binarytodecimal(String n) {
        int answer = 0;
        int digit = n.length();
        int multiplier = 1;
        while (digit > 0) {
            char index = n.charAt(digit - 1);
            if (index == '1') {
                answer += multiplier;
                multiplier *= 2;
                digit--;
            } else {
                multiplier *= 2;
                digit--;
            }
        }
        return answer;
    }