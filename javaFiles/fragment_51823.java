if(dtoValue != null){

    // Display all matches
    RegExp regExp = RegExp.compile(searchTerm, "gi");
    MatchResult matcher = regExp.exec(dtoValue);
    while (matcher != null) { 
        System.out.println(matcher.getGroup(0));  // print Match value (demo)
        matcher = regExp.exec(dtoValue); 
    }

    // Wrap all searchTerm occurrences with 1 and 0
    RegExp regExp1 = RegExp.compile("(" + searchTerm + ")", "gi");
    newDtoData = regExp1.replace(dtoValue, "1$10");
    System.out.println(newDtoData);
    // => 1On0 C1on0diti1on0
}