String yourString = "The quick <brown> fox jumps over the <lazy> dog";
Pattern pattern = Pattern.compile("<(.*?)>");
Matcher matcher = pattern.matcher(yourString);
while(matcher.find()){
   String word = matcher.group(1);
   // do something with the word (like putting it in your hashtable)
}