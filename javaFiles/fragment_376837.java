Collections.sort(announceList, new Comparator<Announce>() {
   @Override
   public int compare(Announce o1, Announce o2) {
       return Double.compare(o2.getMatchPercentage(), o1.getMatchPercentage());
   }
});