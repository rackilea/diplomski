double myDouble = myObject.getDoubleMethod(); // returns 38.1882352941176
System.out.println(myDouble);

String myDoubleString = "" + myDouble;
System.out.println(myDoubleString);

myDoubleString = myDoubleString.replace(".", ",");
System.out.println(myDoubleString);

myDoubleString = myDoubleString.replace('.', ',');
System.out.println(myDoubleString);