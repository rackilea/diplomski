String s ="S3R4";
Pattern pattern = Pattern.compile("^S([\\d]+)R([\\d]+)$");
Matcher matcher = pattern.matcher(s);
if(matcher.find()){
System.out.println((Integer.parseInt(matcher.group(1))*Integer.parseInt(matcher.group(2))));
}