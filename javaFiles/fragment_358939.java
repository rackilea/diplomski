String list1[] = {"m99076", "m10141", "o87909", "o90876", "l17237"};
     String list2[] = {"1", "foo", "1", "m10141", "s3002", "bar", "1", "u39392", "n6233", "fubar", "1", "o87909", "z039"};

     for (int i = 0; i < list1.length; i++) {
         for (int a = 0; a < list2.length; a++) {

             if (list1[i].equals(list2[a])) {
                 System.out.println("\"" + list1[i] + "\" is equal to \"" + list2[a] + "\"");
             } else {
                 System.out.println("\"" + list1[i] + "\" is not equal to \"" + list2[a] + "\"");
             }

         }
     }