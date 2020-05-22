ArrayList<Integer>[] pl2 = new ArrayList[10];                // warning 

ArrayList<String> wrongArrayList = new ArrayList<String>();  // OK!
wrongArrayList.add("string1");                               // OK! 
wrongArrayList.add("string2");                               // OK!

pl2[0] = wrongArrayList;                                     // ERROR