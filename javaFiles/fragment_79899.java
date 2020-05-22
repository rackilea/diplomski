public static void main(String[] args) throws Exception {
    String s = "{(Kumar,39)},(Raja, 30), (Mohammad, 45),{(balu,29)}";
    // Create / compile a pattern that captures everything between each "()"
    Pattern p = Pattern.compile("\\((.*?)\\)");
   //Create a matcher using the pattern and your input string. 
    Matcher m = p.matcher(s);
   // As long as there are matches for that pattern, find them and print them.
    while(m.find()) {
        System.out.println(m.group(1)); // print data within each "()"
    }
}