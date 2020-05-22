String test = "<172>Lorem Ipsum";
int index1 = test.indexOf('<');
int index2 = test.indexOf('>', index1);

String result = test.substring(index1 + 1, index2);
System.out.println("result = " + result);