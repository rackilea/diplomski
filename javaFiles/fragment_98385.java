String a = "?drug <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/possibleDiseaseTarget> ?disease .";
String b = "?drug <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/molecularWeightAverage> ?weight . ?drug <http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/possibleDiseaseTarget> ?disease";

Pattern p = Pattern.compile("\\?drug (<[^>]+>) \\?disease");
Matcher m = p.matcher(a);
while (m.find()) {
    System.out.println(m.group(1));
}
System.out.println("-----------");
m = p.matcher(b);
while (m.find()) {
    System.out.println(m.group(1));
}