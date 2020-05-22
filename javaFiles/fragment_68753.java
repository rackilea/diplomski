String pattern = "{0},{1},{2},{3},{4}";
String[] patternArray = pattern.split("}");
Object[] values = {"abc", "cde", "gef"};
StringBuilder patternBuilder = new StringBuilder();
for(int i = 0; i < values.length; ++i){
  patternBuilder.append(patternArray[i]).append("}");
}
pattern = patternBuilder.toString();
MessageFormat messageFormat = new MessageFormat(pattern);
StringBuffer header = new StringBuffer();
System.out.println(messageFormat.format(values, header, null));