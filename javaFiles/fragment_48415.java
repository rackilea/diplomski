Pattern p = Pattern.compile("[\\s]*javascript:[\\s]*m\\((-?\\d+)[\\s]*,[\\s]*(-?\\d+)[\\s]*,[\\s]{0,}encodeURIComponent\\(\\'([^\\']+)*\\'\\)[\\s]*,[\\s]*(-?\\d+)\\)[\\s]*");
Matcher m = p.matcher("javascript:m(53022,2,encodeURIComponent('Cr 12045'), 85)");
List<String> groups = new ArrayList<>();
while (m.find()) {
    for (int i=1; i<=m.groupCount(); i++){
        groups.add(m.group(i));
    }
}

System.out.println(groups); //[53022, 2, Cr 12045, 85]