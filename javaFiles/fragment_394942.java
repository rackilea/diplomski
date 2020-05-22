String[] wordsList = {"Car", "Racoon"};
    String searchInput = "c r";

    String searchRegEx = searchInput.replace(" ", ".{1}");
    Pattern pattern = Pattern.compile(searchRegEx, Pattern.CASE_INSENSITIVE);
    System.out.println("RegEx (case-insensitive) is: " + searchRegEx);

    for (String word : wordsList){
        Matcher matcher = pattern.matcher(word);
        boolean match = matcher.matches();
        System.out.println("Test word '"+word + "' and match was: " + match);
    }