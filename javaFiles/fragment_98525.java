final Document document = Jsoup.connect("https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=Feed%20Meh%20Dog").get();
    final Element body = document.selectFirst("body");

    String[] rawSkills = body.html().split(" ");
    ArrayList<String[]> skills = new ArrayList<>();

    for(String s: rawSkills ) {
        skills.add(s.split(","));
    }

    System.out.println(skills.get(0)[1]);