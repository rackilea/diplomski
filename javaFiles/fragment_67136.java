public Level findLevel(List<Level> levels, int score){
   for (Level level : levels){
        if (score >= level.getRequiredScore()){
             return level;
        }
   }
    throw new RuntimeException("should not come here !");
}