String s = "sample_filename_AB12123321.pdf";
Pattern pattern = Pattern.compile("(?<=_)[^_]{2}(?=[^_]*$)");
Matcher matcher = pattern.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group(0)); 
}