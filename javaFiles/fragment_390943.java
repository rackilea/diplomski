String text = "|tab_PRO|1|1|#tRecordType#||0|tab_PRO|";
Pattern p = Pattern.compile("\\|([^\\|]*)");
Matcher m = p.matcher(text);
while(m.find()){
    System.out.println(m.group(1));
}