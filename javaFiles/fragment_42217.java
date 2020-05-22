//Compilation of the regex
    Pattern p = Pattern.compile("(\d*)");
    // Creation of the search engine
    Matcher m = p.matcher("15 foxes chases 12 rabbits");
    // Lunching the searching 
    boolean b = m.matches();
    // if any number was found then
    if(b) {
        // for each found number
        for(int i=1; i <= m.groupCount(); i++) {
            // Print out the found numbers;
    // if you want you can store these number in another array 
//since m.group is the one which has the found number(s)
            System.out.println("Number " + i + " : " + m.group(i));
        }
}