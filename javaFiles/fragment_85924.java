String  str= "abc=1,abc=2,abc=3, name=thomas,bcd=5, ghi=6";
int indexOfName = str.indexOf("name=");
String sub = str.substring(indexOfName);//string starting with name=
int commaIndex = sub.indexOf(",");//index of first comma after name=thomas,
String [] arr = sub.substring(commaIndex).split(",");//split everything after name=thomas by comma into array
arr[0] = str.substring(0,indexOfName + commaIndex);//since we split on the exact index of the comma after name=thomas, there is an empty string in position 0
//we then set this empty position equal to the start of the whole string, and end the string right before the comma after name=thomas