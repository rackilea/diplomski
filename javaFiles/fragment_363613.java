String sentence = "this is my sentence \"   course of math\" of this year"; 
String[] MyStrings = sentence.split("\"");
String res = MyStrings.length == 1 ? MyStrings[0] :  // If no split took place use the whole string
    MyStrings[1].trim().indexOf(" ") > -1 ?          // If the second element has space
      MyStrings[1].trim().substring(0, MyStrings[1].trim().indexOf(" ")): // Get substring
      MyStrings[1];                                  // Else, fetch the whole second element
System.out.println(res);