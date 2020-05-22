String line = "Attorney General William Barr said the volume of information compromised was “staggering” and the largest breach in U.S. history.“This theft not only caused significant financial damage to Equifax but invaded the privacy of many, millions of Americans and imposed substantial costs and burdens on them as they had to take measures to protect themselves from identity theft,” said Mr. Barr.";
String regex = "[“\"]([A-Za-z0-9.-][A-Za-z,:’]*(?:\\s+[A-Za-z0-9.-][A-Za-z,:’]*){4,})[”\"]";
Matcher m = Pattern.compile(regex).matcher(line);
List<String> res = new ArrayList<>();
while(m.find()) {
    res.add(m.group(1));
}
System.out.println(res);