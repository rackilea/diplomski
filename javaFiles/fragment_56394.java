String s = "DIC: C/40764176 IC: 407641'6";

Pattern p = Pattern.compile("C/([^\\s]{8,10})\\sIC:");
Matcher m = p.matcher(s);

if (m.find()) {
    System.out.println(m.group(1)); // 40764176
}