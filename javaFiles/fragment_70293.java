String str = "xxxxxxx , yyyyyyy - zzzzzz";
System.out.println(str.split(pattern)[0]);
str = "xxxxxxx - zzzzzz";
System.out.println(str.split(pattern)[0]);
str = "xxxxxxx, zzzzzz";
System.out.println(str.split(pattern)[0]);
str = "xxxxxxx-zzzzzz";
System.out.println(str.split(pattern)[0]);