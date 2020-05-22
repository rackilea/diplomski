String regExpCharacter = "(?s)(.*)HI(.*)";
String val="HI  How  are you";
String secondValue="HI  How \r are you";
String thirdValue="HI  How \n are you";         
System.out.println(val.matches(regExpCharacter));
System.out.println(secondValue.matches(regExpCharacter));
System.out.println(thirdValue.matches(regExpCharacter));