public int compare(String o1, String o2) {
       int pos1 = 0;
       int pos2 = 0;
       for (int i = 0; i < Math.min(o1.length(), o2.length()) && pos1 == pos2; i++) {
          pos1 = ORDER.indexOf(o1.charAt(i));
          pos2 = ORDER.indexOf(o2.charAt(i));
       }

       if (pos1 == pos2 && o1.length() != o2.length()) {
           return o1.length() - o2.length();
       }

       return pos1  - pos2  ;
    }