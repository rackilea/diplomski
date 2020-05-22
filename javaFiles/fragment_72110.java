@Override
public int compare(Game o1, Game o2) {
    int score1 = o1.scores.size();
    int score2 = o2.scores.size();
    return Integer.compare(score1, score2);
}