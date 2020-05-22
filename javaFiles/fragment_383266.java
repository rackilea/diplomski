private static Double calculateScoreSum(Set<? extends Scorable> scoreSet) {
    Double sum = 0.0;
    for (Scorable score : scoreSet){
        sum += score.getScore();
    }
    return sum;
}