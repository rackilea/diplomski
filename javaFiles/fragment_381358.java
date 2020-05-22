StringBuilder newstring = new StringBuilder();
    try {
        for (int i = 0; i < str.length; i++) {
            // System.out.println(str[i]);
            wrd = str[i];
            System.out.println("Hi" + str[i]);
           char chars[] = wrd.toCharArray();// converting your string in chars
               for(int k=chars.length-1;k>=0;k--){
                   newstring.append(chars[k]); // appending your characters in reverse order
               } 
               newstring.append(' ');// appending `space` after each word


        }
    } catch (Exception e) {
        System.err.println(e);
    }
    System.out.println(newstring);// printing your entire reversed string