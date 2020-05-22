// get the index of the start of the second word
      int index = line.indexOf (' ');
      // get the first char of the second word
      char c = line.charAt(index+1);
      /* this is a bit ugly, yet necessary in order to convert the
       * first char to upper case */
      String start = String.valueOf(c).toUpperCase(); 
      // adding the rest of the sentence
      start += line.substring (index+2);
      // adding space to this string because we cut it
      start += " ";
      // getting the first word of the setence
      String end = line.substring (0 , index);
      // print the string
      System.out.println(start  + end);