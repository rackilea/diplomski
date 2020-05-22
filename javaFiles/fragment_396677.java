int i;
        for (i = 0; i < lowerCaseWord.length(); i++) {
            if(lowerCaseWord.charAt(i) > 'z' || lowerCaseWord.charAt(i) < 'a') {
                break;
            }
        }
        String a = lowerCaseWord.substring (2, i);
        String b = lowerCaseWord.substring(i);
        return a + "qu" + "ay" + b;