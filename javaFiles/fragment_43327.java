String mystring = "inflation != stealing";
char[] my_char_array = mystring.toCharArray();
StringBuilder sb = new StringBuilder();
sb.append(mystring);
sb.deleteCharAt(10);
my_char_array = sb.toString().toCharArray();
System.out.println(my_char_array);             //prints "inflation = stealing"