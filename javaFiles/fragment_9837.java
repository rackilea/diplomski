Pattern pattern = Pattern.compile("[a-z][0-9]{2}");
Matcher matcher = pattern.matcher("sedfdhajkldsfakdsakvsdfasdfr30.reed.op.1xp0");

if(matcher.find()) {
    System.out.println(matcher.group());    
}