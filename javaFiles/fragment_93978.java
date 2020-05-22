ByteBuffer bb = /* byte buffer */
String text = new String(bb.array(), 0, bb.position(), bb.remaing(), Charset.defaultCharset());

// I assume that this is the string: "8=FIX.4.2|9=00815|35=W|49=TT_PRICE|56=SAP0094X|10=134|8=FIX.4.2|9=00816|35=W49=TT_PRICE|56=SAP0094X|10=121"

// If you need info on the regex just ask for it
Pattern r = Pattern.compile("(8=\\w\\w\\w)[\\s\\S]*?(10=\\w\\w\\w)");
Matcher m = r.matcher(text);

while (m.find()) {
     System.out.println(m.group());
}