Pattern p = Pattern.compile("\\bcolor=(\\w\\d*,\\d*,\\d*)");
Matcher m = p.matcher(url);
if(m.find()){
    return m.group(1);
}
else {
    return "0,0,0";
}