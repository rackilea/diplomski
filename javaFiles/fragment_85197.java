String testString = "$Hello$Dear$";

     String[] result = testString.split("\\$");
     System.out.println("Length is "+ result.length); //3
     int i=1;
     for(String str : result) {
        System.out.println("Str"+(i++)+" "+str);
     }