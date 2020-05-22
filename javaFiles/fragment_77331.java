String message = receiveMessage();
message  = message.replaceAll("[\n\r\\s]", "");
String[] str1 = message.split("[|]");
for (int i = 0; i < str1.length; i++) {
    System.out.println(str1[i]);
}