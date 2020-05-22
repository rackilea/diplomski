String str = "fixedwidth:60";
String[] arr = str.split(":");
int val = Integer.parseInt(arr[1]);
// OR -
// int val = Integer.valueOf(arr[1]);
System.out.println(val);