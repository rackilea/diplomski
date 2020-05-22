class CricketTeamComparator implements Comparator<CricketTeam> {
    @Override
    public int compare(CricketTeam o1, CricketTeam o2) {
        String lastName1 = o1.name.split(" ")[1];
        String lastName2 = o2.name.split(" ")[1];
        return lastName1.compareTo(lastName2);
    }
}

...

List<CricketTeam> team = new ArrayList<CricketTeam>();
...
Collections.sort(team, new CricketTeamComparator());