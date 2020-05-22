StringBuilder sb = new StringBuilder();

String str = "99,111,111,108"; // result of initial conversion
String[] sa = str.split(",");

char ch = '';

for(String s : sa) {
   ch = Integer.parseInt(s);
   sb.append(ch);
}

FileOutputStream fos = new FileOutputStream("new.txt");

fos.write(sb.toString().getBytes());
fos.close();