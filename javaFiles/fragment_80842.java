String s = getSuffixName();
    char sChar = s.charAt(0);

    String initial = " ";

      if(getNumberOfNames() == 0){
        initial = " ";
    }else if(getNumberOfNames() == 1){
        String f = getFirstName(); 
        char fChar = f.charAt(0);
        initial = fChar + ".";
    }else if(getNumberOfNames() == 2){
         String f = getFirstName(); 
         char fChar = f.charAt(0);
         String m = getMiddleName();
         char mChar = m.charAt(0);
         initial = fChar + "." + mChar + ".";
    }else if(getNumberOfNames() == 3){
         String f = getFirstName(); 
         char fChar = f.charAt(0);
         String m = getMiddleName();
         char mChar = m.charAt(0);
         String l = getLastName();
         char lChar = l.charAt(0);
        initial = fChar + "." + mChar + "." + lChar + ".";
    }