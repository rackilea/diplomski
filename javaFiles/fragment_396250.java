int date = 20;
int month = 2;
int year = 2007;
String d = String.format("%0$5s", Integer.toBinaryString(date));
String m = String.format("%0$4s", Integer.toBinaryString(month));
String y = String.format("%0$23s", Integer.toBinaryString(year));

String str = y + m + d;
str = str.replace(' ', '0');
System.out.println(str);
int number = 0;
for (int i = 0; i < str.length(); i++) {
    number = (number << 1) | ((str.charAt(i) != '0') ? 1 : 0);
}
System.out.println(number);
System.out.println(Integer.toBinaryString(number));