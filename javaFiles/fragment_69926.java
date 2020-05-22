Collections.sort(CurrentRankingsList, new Comparator<String[]>() 
 {
    @Override
    public int compare(String[] o1, String[] o2) {
        // TODO Auto-generated method stub
                return o1[0].compareTo(o2[0]);
     }
 }) ;