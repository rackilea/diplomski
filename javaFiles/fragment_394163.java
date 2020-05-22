Pattern startsWithPattern = Pattern.compile("(^\\(?\\d+\\/\\d+\\)?\.)");
    List<String> listOfPrograms = new ArrayList<>();
    List<String> filteredList = new ArrayList<>();
    listOfPrograms.add("The lastest news, sport, business and weather from the BBC's breakfast team...");
    listOfPrograms.add("12/20. Consumer programme. Matt Allwright travels to Kent to join housing officers on inspection...");
    listOfPrograms.add("5/6. Police Drama series. AC-12's loyalties are divided when DS Steve Arnott comes under scrutiny...");
    listOfPrograms.add("(5/6). Police Drama series. AC-12's loyalties are divided when DS Steve Arnott comes under scrutiny...");

    for (String program : listOfPrograms)
    {
        Matcher matcher = startsWithPattern.matcher(program);

        if (matcher.find())
            filteredList.add(program);
    }