String str1 = "?";
byte[] arr1 = str1.getBytes();
String str2 = "\u0080";
byte[] arr2 = str2.getBytes();
System.out.println(str1.equals(str2));
System.out.println(Arrays.equals(arr1, arr2));