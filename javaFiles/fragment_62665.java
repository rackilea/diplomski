int index = content.indexOf("</b>");
System.out.println(index);

String temp1 = content.substring(0, index + 4);
System.out.println(temp1);

String temp2 = content.substring(index + 4);
System.out.println(temp2);

String withNL = temp1 + "\n" + temp2;
System.out.println(withNL);