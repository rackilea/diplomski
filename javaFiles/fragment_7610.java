public static String vowelCount(String sentence) {
        int[] vowelsCounted = new int[5];
        vowelsCounted.toString();
        for (int i=0; i<sentence.length(); i++) {
        char ch = sentence.charAt(i);
        if (ch == 'a') {
            vowelsCounted[0]++;
        } else if (ch == 'e') {
            vowelsCounted[1]++;
        } else if (ch == 'i') {
            vowelsCounted[2]++;
        } else if (ch == 'o') {
            vowelsCounted[3]++;
        } else if (ch == 'u') {
            vowelsCounted[4]++;
        }
        }
        return Arrays.toString (vowelsCounted);
    }