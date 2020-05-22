StringBuilder fullResponse = new StringBuilder();
while((ch = in.read()) != -1) {
    System.out.print((char)ch);
    fullResponse.append(String.valueOf((char)ch));
 }
 jTextArea2.append(fullResponse.toString());
 String id = Jsoup.parse(fullResponse.toString()).getAllElements().attr("id");