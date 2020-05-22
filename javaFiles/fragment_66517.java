public void addScore(List<String> users, int score) {
    HighscoreEntry entry = entries.filter( e -> (e.getUsers().equals(users))).findFirst().orElse(null);
    if (entry != null) {
        entry.setScore(score);
    } 
}