String text = jTextAreaName.getText();

//This is the list of the wanted groups
String[] patterns = new String[]{"(LowPT .+)[\\r\\n]", "(Firmware Version .+)[\\r\\n]", "(Hardware Version .+)[\\r\\n]"};


//Then extract the three matched groups like this
String myResult="";
for(int i=0; i<patterns.length; i++) {
     //compile each matching group and find matches.
     Pattern pattern = Pattern.compile(patterns[i]);
     Matcher matcher = pattern.matcher(text);
     while(matcher.find()) {
         myResult += matcher.group(1);
         myResult += "\n";
     }
}