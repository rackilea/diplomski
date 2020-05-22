String input  ="teamA-teamB 4-5";
    String team1, team2;
    int goals1, goals2;

    Matcher matcher = 
        Pattern.compile("(.*?)\\s*-\\s*(.*?)\\s*(\\d*)\\s*-\\s*(\\d*)")
        .matcher(input);
    if ( matcher.matches() ) {
        team1 = matcher.group(1);
        team2 = matcher.group(2);
        goals1 = Integer.parseInt(matcher.group(3));
        goals2  = Integer.parseInt(matcher.group(4));
        System.out.println(team1 + ":" +  team2 + ":" + goals1 + ":" + goals2);
    }