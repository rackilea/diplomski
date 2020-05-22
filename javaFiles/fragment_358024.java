String input = "TX=\"0000000000108000001830001\" FI=\"\" OS=\"8\" CI=\"QU01SF1S2032\" AW=\"SSS\" SA=\"1525 Windward Concourse\"";

Pattern p = Pattern.compile("\\s*(\\w+)=\"([^\"]*)\"\\s*");

Matcher m = p.matcher(input);
while(m.find()){
    System.out.println(m.group(1));
    System.out.println(m.group(2));
}