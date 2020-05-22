int count=0;
Pattern pattern = Pattern.compile("(?<![_\\p{L}])" + patternName + "(?![_\\p{L}])");
for(File f: fileList) {
    Matcher matcher = pattern.matcher(f.getName());
    if(matcher.find()){
        count++;
    }
}