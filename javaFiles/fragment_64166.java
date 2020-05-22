//Split by tab
String values[] = myTextLineByLine.split("\t");
List<String> list = Arrays.asList(values);
//Reverse the list so that longitude and latitude are the first two elements
Collections.reverse(list);

String longitude = list.get(0);
String latitude = list.get(1);