StringBuffer sb = new StringBuffer();
while(m.find()){
    String wordToReplace = m.group();
    //replace found word with with its replacement in map
    m.appendReplacement(sb, replacementMap.get(wordToReplace));
}
m.appendTail(sb);

String replaced = sb.toString();