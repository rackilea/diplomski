StringBuffer b= new StringBuffer();
Matcher m= Pattern.compile("[A-Za-z]").matcher(phoneStr);
while (m.find()) {
    int ix= (int) (m.group(0).toLowerCase().charAt(0)-'a');
    m.appendReplacement(b, "22233344455566677778889999".substring(ix, ix+1));
}
m.appendTail(b);
return b.toString();