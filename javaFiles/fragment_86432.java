String s = edittext.gettext();
    if(s.length == 5){
      boolean hasString = false;
      boolean hasInt = false;
      String letters = s.substring(0, 2);
      Pattern p = Pattern.compile("^[a-zA-Z]+$");
      Matcher m = p.matcher(letters);
      if (m.matches()) {
        hasString = true;
      }
      String numbers=s.substring(2,5);
      try {
        int num = Integer.parseInt(numbers);
        String n = num + "";
        if (num > 0 && n.length() == 3)
            hasInt = true;
      } catch (Exception e) {
      }
      if (hasInt && hasString) {
        //success
      }
     }else{
      // incorrect string
     }