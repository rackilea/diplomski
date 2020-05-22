public static PlayerScores findHighestScorer(List<PlayerScores> players) {
    PlayerScores bestScore = null;

    // loop through list...
    for (PlayerScores score : players) {
        if (bestScore == null) {
            bestScore = score;
        } else {
            if (bestScore.getAverage() < score.getAverage()) {
                bestScore = score;
            }
        }
    }

    return bestScore;
}