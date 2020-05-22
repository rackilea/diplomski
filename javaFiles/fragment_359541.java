class Match {
   private PersonDO candidate;
   private double score; // 0 - definitely not, 1.0 - perfect match

   // Add candidate/score constructor here
   // Add getters for candidate/score here

   public static final Ordering<Match> SCORE_ORDER =
       new Ordering<Match>() {
     @Override
     public int compare(Match left, Match right) {
       return Doubles.compare(left.score, right.score);
     }
   };
}