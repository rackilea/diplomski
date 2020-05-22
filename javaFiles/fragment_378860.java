public class BBall {

public static void main(String args[]) {

    List<String> teams = new ArrayList<String>();
    teams.add("Boston");
    teams.add("LA");
    teams.add("New York");
    teams.add("Chicago");
    teams.add("Dallas");

    // This option might be a little easier to read.
    int index1 = 0;
    System.out.println("Easy to read:");
    for (String team1 : teams) {
        index1++;
        for (int index2 = index1; index2 < teams.size(); ++index2) {
            System.out.println(team1 + " plays " + teams.get(index2));
        }
    }
    System.out.println("This is set A:");
    for (int x = 1; x < teams.size(); x++) {
        for (int y = x - 1; y >= 0; y--) {
            System.out.println(teams.get(x) + " plays " + teams.get(y));
        }
    }
    System.out.println("This is set B:");
    for (int x = 0; x < teams.size() - 1; x++) {
        for (int y = x + 1; y < teams.size(); y++) {
            System.out.println(teams.get(x) + " plays " + teams.get(y));
        }
    }
}
}