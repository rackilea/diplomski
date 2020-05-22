String sample="Test";
String append="1";
StringBuffer sb=new StringBuffer(sample.length()*append.length());
for(int i=0; i<sample.length(); i++) {
    sb.append(append).append(sample.charAt(i));
}
System.out.println(sb.toString(); //result