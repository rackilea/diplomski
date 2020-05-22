String text = jTextAreaName.getText();

//This is the list of the wanted groups
String[] patterns = new String[]{"(LowPT .+)[\\r\\n]", "(Firmware Version .+)[\\r\\n]", "(Hardware Version .+)[\\r\\n]"};


//Then delete the three matched groups like this
for(int i=0; i<patterns.length; i++) {
    Pattern pattern = Pattern.compile(patterns[i]);
    Matcher matcher = pattern.matcher(text);
    while(matcher.find()) {
       text = matcher.replaceAll("");
    }
}