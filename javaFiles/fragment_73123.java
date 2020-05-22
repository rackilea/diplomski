String source = "HOW do I replace different how in the same sentence by using Matcher?";
    String[] split = source.replaceAll("HOW", "LOL").split(" ");
    String newSource = "";
    for(int i = 0; i < split.length; i++) {
        String at = split[i];
        if(at.equalsIgnoreCase("how"))  at = "lol";
        newSource+= " " + at;
    }
    newSource.substring(1, newSource.length());
//The output string is newSource