String s ="1946: It's a Wonderful Life ($14.95)";
String[] ar = s.split(" ");
System.out.println(ar[0].substring(0, ar[0].length()-1));
String str = String.join("," ,Arrays.copyOfRange(ar, 1, ar.length-2)).replaceAll(",", " ");
System.out.println(str);
System.out.println(ar[ar.length-1].substring(2, ar[ar.length-1].length()-1));