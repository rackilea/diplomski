public static String charCount(String [] a){
  String chc="" ;

  for (int i = 0; i < a.length; i++) {
     for (int j = 0; j < a[i].length(); j++) {
        char ch = a[i].charAt(j);
        int charcout = a[i].length();
        chc=  Character.toString(ch)+""+Integer.toString(charcout)+" ";
        //  String chc=  ch + "" + charcout + " ";
        // return chc;  
        System.out.print(chc);
     }
  } 
  // The next line is the problem. Why do you print here?
  System.out.print(chc);
  return null;  
  }