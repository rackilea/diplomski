private void updateAverage(GLabel average) {
 if(TOTAL_GAMES == 0){
    average.setLabel("0");
    return;
  }
average.setLabel(String.valueOf("Avg: " 
     + String.valueOf((int)((AI_SCORE + PLAYER_SCORE) / TOTAL_GAMES))));
average.setLocation(getWidth() / 2 - average.getWidth() / 2,
     getHeight() - PADDING);
TOTAL_GAMES++;
}