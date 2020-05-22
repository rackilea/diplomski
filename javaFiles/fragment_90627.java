public static String capsFirst(String str) 
    {
        String[] words = str.split(" ");

        StringBuilder ret = new StringBuilder();

        for(int i = 0; i < words.length; i++) 
        {
          if (words[i].length() == 0){
            ret.append(' ');
            continue;
          }

          if (Character.isLetter(words[i].charAt(0))){
            ret.append(Character.toUpperCase(words[i].charAt(0)));
            ret.append(words[i].substring(1));
          }
          else{
            ret.append(words[i]);
          }

            if(i < words.length - 1) 
            {
                ret.append(' ');
            }
        }

        return ret.toString();
    }