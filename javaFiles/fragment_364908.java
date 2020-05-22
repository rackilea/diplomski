String s = "Frequency/FA ID VerifiedFA0 FAID5(125)/FA1 FAID7(175)/FA2 FAID1(476)";
Pattern patt = Pattern.compile("\\(\\d+\\)");
Matcher match = patt.matcher(s);
while(match.find()){
    System.out.println(match.group());
}