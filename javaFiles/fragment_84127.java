Pattern p = Pattern.compile(".*? \[name=(.*?), department=(.*?)\]");
Matcher m = p.matcher(yourKey);

if (m.find()) {
    System.out.println(m.group(1)); // contains the name
    System.out.println(m.group(2)); // contains the departement
}