int totalVowels=0;

       int letterA=(s1.indexOf(('a')));
       int letterE=(s1.indexOf(('e')));
       int letterO=(s1.indexOf(('o')));
       int letterI=(s1.indexOf(('i')));
       int letterU=(s1.indexOf(('u')));

       if(letterA >=0){
          totalVowels ++; (this increments the total number of vowels)
       }
       if(letterE >=0){
          totalVowels ++; 
       }
       if(letterO >=0){
          totalVowels ++; 
       }
       if(letterI >=0){
          totalVowels ++; 
       }
       if(letterU >=0){
          totalVowels ++; 
       }

      System.out.println ("String1 contains" + totalVowels +" of the 5 vowels");
      totalVowels =0;