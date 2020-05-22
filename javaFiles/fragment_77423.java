String s = "rule apt_regin_2011_32bit_stage1 {";
Pattern pattern = Pattern.compile("rule ([a-zA-Z0-9 .,/!()\\-+=_:$@#'&*]+) \\{");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}