boolean test2 = true;
   boolean test3 = true;
   for (String s : splitString) {
        for (int i = 0 ; i < s.length() ; i++) {
            if (!Character.isLetter(s.charAt(i))) {
                test3 = false;
            }
        }
        if (s.length() < 2 && ) {
            test2 = false;
            break;
        }
    }