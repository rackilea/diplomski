public void setPureRatingsList(List<List<Integer>> lst)
{
  pureRatingsList = lst;
}

public List<List<Integer>> getPureRatingsList()
{
  return Collections.unmodifiableList(pureRatingsList);
}