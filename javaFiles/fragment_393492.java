String original1 = "Calpol Plus 100MG";
String strs[] = original1.split("\\s+(?=\\d+M[LG])");
String string1 = strs[0];
String string2 = strs[1];
System.out.println(string1);
System.out.println(string2);