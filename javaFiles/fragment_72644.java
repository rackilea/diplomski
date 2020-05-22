String firstname = "";

   for (int i = 0; i < names.length; i++) {
       int amount = 0;
       boolean skip = false;

       for (int j=0; j < names.length; j++) {
          //need to skip because we have already processed it
          if(names[j].equals(names[i]) && i > j) {
              skip = true;
              break;
          } 
          else if (names[j].equals(names[i])) {
               amount += scores[j];
          }
       }
       if(!skip) {
         System.out.println(names[i] + "  " + amount);
       }
   }