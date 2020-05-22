for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ' ' || str.charAt(i) == '\t' || str.charAt(i) == '\n') {
            // end of token, check if key word
            String currentWord = s.toString();     
            boolean isKeyword = false       
            for (int j = 0; j < keywords.length; j++) { 
                if (currentWord.equalsIgnoreCase(keywords[j])) { 
                    isKeyword = true;
                    break;
                } 
            }
            if(isKeyword) {
                System.out.println("Reserved word is: ["  + currentWord + "]");
            } else {
                System.out.println("Current word is: [" + currentWord + "]");
            }
            s = "";//Clear the string to get it ready to build next token.
        } else {
            // continue building token
            s += str.charAt(i) + "";
        }
    }