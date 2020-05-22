String name = "Thuan";
String age = "27";
String sex = "male";
String s = "Name:" + name + "Age:" + age + "Sex:" + sex;

int nameIndex = s.indexOf("Name:");
int ageIndex = s.indexOf("Age:");
int sexIndex = s.indexOf("Sex:");

String theName = s.substring(nameIndex + "Name:".length(), ageIndex);
String theAge = s.substring(ageIndex + "Age:".length(), sexIndex);
String theSex = s.substring(sexIndex + "Sex:".length(), s.length());

System.out.println(theName);
System.out.println(theAge);
System.out.println(theSex);