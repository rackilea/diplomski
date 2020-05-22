Comparator<CollegeList> compareByScoreDistance = new Comparator<CollegeList>() {
     @Override
     public int compare(CollegeList a, CollegeList b) {
         return Double.compare(a.getScoreDistance(), b.getScoreDistance());
     }
};