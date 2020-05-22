public static void main(String args[]){
    String ccPattern = "((?:(?:\\d{4}[- ]){3}\\d{4}|\\d{16}))(?![\\d])";
    Pattern pattern = Pattern.compile(ccPattern);
    Matcher matcher = pattern.matcher("My credit card number is 4444-4444-4444-4448.");
    if(matcher.find()){
        System.out.println("Pattern matches");
        System.out.println(matcher.group(0));
    }
    else{
        System.out.println("Does not matches");
    }
}