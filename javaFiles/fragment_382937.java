String text = "ôð¤ Ø$î1<¨ V¸dPžÐ ÀH@ˆàÀà¼€@`~€4";
Writer writer = new OutputStreamWriter(new FileOutputStream("test.txt"), "windows-1252");
writer.append(text);
writer.close();
BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"), "windows-1252"));
String line = br.readLine();
br.close();
System.out.println(line.length() + ": '" + line + "' matches " + line.equals(text));