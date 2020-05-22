public void calculateMax(Integer year){
      if (year == 2006 && hoodDataList.stream().anyMatch(c -> c.getYear() == 2006))
      {
           double max = hoodDataList.stream().filter(c -> c.getYear() == 2006).
           max((c1, c2) -> Double.compare(c1.getPercentage(),c2.getPercentage())).
           get().getPercentage();
           Toast.makeText(getActivity(), String.valueOf(max),
           Toast.LENGTH_LONG).show();
      }else
      {
          //do something else
      }
}