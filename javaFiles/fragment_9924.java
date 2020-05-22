Matcher m = Pattern.compile("<variable>").matcher(input);
StringBuffer sb = new StringBuffer();
for( int i = 0; m.find(); i++){
    m.appendReplacement(sb, "{"+i+"}");
}
m.appendTail(sb);