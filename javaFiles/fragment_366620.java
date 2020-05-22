Set<String> teamSet = new TreeSet<>();
Collections.addAll(teamSet, teams);

System.out.println("Please enter a team: ");
String teamName = input.nextLine();

if (teamSet.contains(teamName)) {
    System.out.println("You like: " + teamName);
} else {
    System.out.println("Who?");
}