String[] data = {
        "showname.s01e01e02e03.extension",
        "showname.s01e01-02-03.extension",
};
Pattern p = Pattern.compile(
                "[.]s(?<season>\\d{1,4})e(?<episodes>\\d{1,3}([e-]\\d{1,3})+)[.]",
                Pattern.CASE_INSENSITIVE);
for (String input : data){
    Matcher m = p.matcher(input);
    while (m.find()){
        String season = m.group("season");
        System.out.println(season);
        String episodes = m.group("episodes");
        System.out.println(m.group("episodes"));
        String[] singleEpisodes = episodes.split("[e-]");

        System.out.println("episode numbers"+Arrays.toString(singleEpisodes));
    }
    System.out.println("-----");
}