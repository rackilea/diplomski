String line = "122. FardinAbir 170213";
Pattern pattern = Pattern.compile("^(\\d+)");
Matcher matcher = pattern.matcher(line);
if(matcher.find()) {
    int id = Integer.parseInt(matcher.group(1));
    System.out.println(id);
}